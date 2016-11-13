package coletor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import dao.DAOGenerica;
import entity.entitys.*;
import entity.enums.ModoCadastro;
import entity.enums.Natureza;
import entity.enums.TipoEntidade;
import entity.enums.TipoNota;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.criterion.MatchMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javassist.NotFoundException;

public class ParseNfe {

    private static DAOGenerica dao;

    private String nfe_html;
    private Document doc;
    private Document prod;

    private TipoNota tipo;
    private Entidade emitente;
    private Entidade destinatario;
    private Entidade empresa;
    private String chave;
    private Date emissao;
    private double valorTotal;
    private long numero;
    private String serie;
    private Natureza natureza;
    private ModoCadastro modoCadastro;
    private Usuario usuario;
    private List<Movimentacao> movimentacao;
    private NotaFiscal nota;

    public ParseNfe(String nfe_html) {
        this.nfe_html = nfe_html.replaceAll("&nbsp;", "").replace("\u00a0", "");

        doc = Jsoup.parse(this.nfe_html, "UTF-8", Parser.xmlParser());
        dao = new DAOGenerica();
    }

    public void rodar() {

        empresa = new Entidade();//(Entidade) dao.buscarPorPropriedade(Entidade.class, "cnpjCpf", teste).get(0);
        empresa.setCpfCnpj((long) 123456789);

        emitente = novaEntidade(doc.select("#Emitente").first());
        destinatario = novaEntidade(doc.select("#DestRem").first());
        serie = retornaElemento(doc, "Série");
        tipo = verificaTipoNota();
        chave = retornaElemento(doc, "Chave de Acesso");
        emissao = getData(retornaElemento(doc, "Data de Emissão"));

        valorTotal = Double.parseDouble(getDouble(retornaElemento(doc, "ValorTotaldaNotaFiscal")));

        numero = Long.parseLong(retornaElementoPorClasse(doc, "fixo-nro-serie", 1).replaceAll(",", "."));

        natureza = getNatureza(retornaElemento(doc, "Natureza da Operação"));
        modoCadastro = ModoCadastro.IMPORTACAO;
        usuario = null;
        movimentacao = mvtoNota(doc.select("#Prod").first());

        nota = new NotaFiscal(chave, emissao, valorTotal, emitente, numero, serie, tipo, natureza, movimentacao, modoCadastro, usuario);
        dao.save(nota);

    }

    public TipoNota verificaTipoNota() {
        if (emitente.getCpfCnpj() == empresa.getCpfCnpj()) {
            return TipoNota.ENTRADA;
        }
        if (destinatario.getCpfCnpj() == empresa.getCpfCnpj()) {
            tipo = TipoNota.SAíDA;
        }
        return null;
    }

    public Entidade novaEntidade(Element entidadeElem) {

        Endereco ende = new Endereco();
        ende.setLogadouro(retornaElemento(entidadeElem, "Endereço"));
        ende.setBairro(retornaElemento(entidadeElem, "Bairro / Distrito"));
        ende.setCidade(retornaElemento(entidadeElem, "Município").replaceAll("\\s+", " "));
        ende.setEstado(retornaElemento(entidadeElem, "UF"));

        String nome = retornaElemento(entidadeElem, "Nome / Razão Social");
        String apelido = retornaElemento(entidadeElem, "Nome / Razão Social");
        String nomeFantasia = retornaElemento(entidadeElem, "Nome Fantasia");

        ModoCadastro modoCadastro = ModoCadastro.IMPORTACAO;
        LocalDateTime dataCadastro = LocalDateTime.now();
        Usuario user = null;
        TipoEntidade tipoPessoa = verificaPessoa(entidadeElem);
        
        Long cpfCnpj = Long.parseLong(removePontuacaoInsc(verificaCpfCnpj(entidadeElem, tipoPessoa)));
        
        Entidade ent = cadastrarEntidade(tipoPessoa, nome, nomeFantasia, cpfCnpj, apelido, ende, dataCadastro, modoCadastro, user);
        return ent;
    }

    public List<Movimentacao> mvtoNota(Element prods) {

        List<Produto> produtoList = new ArrayList<Produto>();
        List<Movimentacao> movtoList = new ArrayList<Movimentacao>();

        int ncm;
        Long codigo;
        String descricao;
        String tipo = null;
        String unidadeSigla;
        boolean permiteFracionar = true;
        double quantidade;
        double total;
        double unitario;
        double desconto;

        ModoCadastro modoCadastro = ModoCadastro.IMPORTACAO;
        Usuario usuario = null;
        Movimentacao movimentacao;
        Produto produto;
        Categoria categoria = cadastrarCategoria("IMPORTACAO");
        UnidadeMedida unidade = new UnidadeMedida();

        Element prodHeader;
        Element prodContent;

        Elements boxes = prods.children().first().child(1).children();
        boxes.remove(0);

        for (int i = 0; i < boxes.size(); i = i + 2) {

            prodHeader = boxes.get(i);
            prodContent = boxes.get(i + 1);

            unidadeSigla = prodHeader.select(".fixo-prod-serv-uc").text();
            descricao = prodHeader.select(".fixo-prod-serv-descricao").text();

            codigo = Long.parseLong(retornaElemento(prodContent, "Código do Produto"));
            ncm = Integer.parseInt(retornaElemento(prodContent, "Código NCM"));

            unidade = cadastrarUnidade(unidadeSigla);
            produto = cadastrarProduto(descricao, unidade, permiteFracionar, tipo, ncm, categoria);
            quantidade = getValor(prodHeader, "fixo-prod-serv-qtd");

            total = getValorPorClasse(prodHeader, "fixo-prod-serv-vb");
            unitario = getValorPorDescricao(prodContent, "Valor unitário de comercialização");
            desconto = getValor(prodContent, "Valor do Desconto");

            movimentacao = new Movimentacao(produto, quantidade, unidade, nota, total, unitario, desconto, modoCadastro, usuario);
            movtoList.add(movimentacao);
            dao.save(movimentacao);

        }
        return movtoList;

    }

    public Produto cadastrarProduto(String descricao, UnidadeMedida unidade, boolean permiteFracionar, String tipo, int codigoNcm, Categoria categoria) {
        Produto produto;

        List<Produto> produtoList = dao.buscarPorPropriedade(Produto.class, "descricao", descricao, MatchMode.EXACT);

        if (produtoList.isEmpty()) {
            produto = new Produto(descricao, unidade, permiteFracionar, tipo, codigoNcm, categoria);
            dao.save(produto);
        } else {
            produto = produtoList.get(0);
        }

        return produto;
    }

    public UnidadeMedida cadastrarUnidade(String unidadeSigla) {

        UnidadeMedida unidade;

        List<UnidadeMedida> unidadeList = dao.buscarPorPropriedade(UnidadeMedida.class, "sigla", unidadeSigla, MatchMode.EXACT);

        if (unidadeList.isEmpty()) {
            unidade = new UnidadeMedida(unidadeSigla, unidadeSigla);
            dao.save(unidade);
        } else {
            unidade = unidadeList.get(0);
        }

        return unidade;
    }

    public Entidade cadastrarEntidade(TipoEntidade tipoPessoa, String nome, String nomeFantasia, Long cnpjCpf, String apelido,
            Endereco endereco, LocalDateTime dataCadastro, ModoCadastro modoCadastro, Usuario usuario) {

        Entidade ent;

        List<Entidade> entidadeList = dao.buscarPorPropriedade(Entidade.class, "cnpjCpf", cnpjCpf);
        //List<Entidade> entidadeList = dao.buscarPorPropriedade(Entidade.class, "cnpjCpf", cnpjCpf.toString(), MatchMode.EXACT);

        if (entidadeList.isEmpty()) {
            dao.save(endereco);
            ent = new Entidade(tipoPessoa, nome, nomeFantasia, cnpjCpf, apelido, endereco, modoCadastro);
            dao.save(ent);
        } else {
            ent = entidadeList.get(0);
        }

        return ent;

    }

    public Categoria cadastrarCategoria(String categoriaDesc) {

        Categoria categoria;

        List<Categoria> categoriaList = dao.buscarPorPropriedade(Categoria.class, "nome", categoriaDesc, MatchMode.EXACT);

        if (categoriaList.isEmpty()) {
            categoria = new Categoria(categoriaDesc);
            dao.save(categoria);
        } else {
            categoria = categoriaList.get(0);
        }

        return categoria;
    }

    public TipoEntidade verificaPessoa(Element entidadeElem) {
        if (entidadeElem.select(":containsOwn(CNPJ)").isEmpty()) {
            return TipoEntidade.FÍSICA;
        }
        return TipoEntidade.JURIDICA;
    }

    public String verificaCpfCnpj(Element entidadeElem, TipoEntidade tipo) {


        if (tipo == TipoEntidade.FÍSICA) {
            return retornaElemento(entidadeElem, "CPF");
        } else {
            return retornaElemento(entidadeElem, "CNPJ");
        }
    }

    public String removePontuacaoInsc(String s) {
        return s.replaceAll("\\W", "");
    }

    public Date getData(String data) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            //05/07/2016 08:33:00-02:00
            return formato.parse(data.substring(0, 10));
        } catch (ParseException ex) {
            Logger.getLogger(ParseNfe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String retornaElementoPorClasse(Element el, String classe, int child) {
        try {
            return el.select("." + classe).first().child(child).text();

        } catch (Exception e) {
            return "";
        }
    }

    public String retornaElemento(Element el, String campo) {
        try {
            return el.select(":containsOwn(" + campo + ")").first().parent().child(1).text();

        } catch (Exception e) {
            return "";
        }

    }

    private Natureza getNatureza(String el) {
        if (el.contains("VENDA")) {
            return Natureza.VENDA;
        }
        if (el.contains("DEVOLUÇÃO")) {
            return Natureza.DEVOLUÇÃO;
        }
        if (el.contains("BONIFICAÇÃO")) {
            return Natureza.BONIFICAÇÃO;
        }
        return null;
    }

    private String getDouble(String d) {
        return d.replace(".", "")
                .replace(",", ".");
    }

    private double getValor(Element e, String s) {
        try {
            return Double.parseDouble(getDouble(retornaElementoPorClasse(e, s, 0)));
        } catch (Exception ex) {
            return 0;
        }
    }

    private double getValorPorClasse(Element e, String s) {
        try {
            return Double.parseDouble(getDouble(retornaElementoPorClasse(e, s, 0)));
        } catch (Exception ex) {
            return 0;
        }
    }

    private double getValorPorDescricao(Element e, String s) {
        try {
            return Double.parseDouble(retornaElemento(e, s).replaceAll(",", "."));
        } catch (Exception ex) {
            return 0;
        }
    }

}