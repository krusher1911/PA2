
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import dao.DAOGenerica;
import entity.entitys.*;
import entity.enums.ModoCadastro;
import entity.enums.TipoEntidade;
import entity.enums.TipoNota;
import java.util.List;
import org.hibernate.criterion.MatchMode;
import java.time.LocalDateTime;

/**
 *
 * @author Gustavo
 */
public class ParseNfe {

    private static DAOGenerica dao = new DAOGenerica();

    private String nfe_html;
    private Document doc = Jsoup.parse(nfe_html, "UTF-8", Parser.xmlParser());
    ;
    private Document prod;

    private TipoNota tipo = TipoNota.ENTRADA;

    public ParseNfe(String nfe_html) {
        this.nfe_html = nfe_html;
    }

    public void rodar() {
        produtosNota(doc.select("#Prod").first());
        produtosNota(doc.select("#Emitente").first());
        //Emitente

    }

    public Entidade novaEntidade(Element entidadeElem) {
        Entidade ent = new Entidade();

        Endereco ende = new Endereco();
        ende.setLogadouro(retornaElemento(entidadeElem, "Endereço"));
        ende.setBairro(retornaElemento(entidadeElem,    "Bairro / Distrito"));
        ende.setCidade(retornaElemento(entidadeElem,    "Município").replaceAll("\\s+", " "));
        ende.setEstado(retornaElemento(entidadeElem,    "UF"));
        
        ent.setEndereco(ende);

        String nome = retornaElemento(entidadeElem, "Nome / Razão Social");
        ent.setNome(nome);
        
        String apelido = retornaElemento(entidadeElem, "Nome / Razão Social");
        ent.setApelido(apelido);
        
        String nomeFantasia = retornaElemento(entidadeElem, "Nome Fantasia");
        ent.setNomeFantasia(nomeFantasia);
        
        ModoCadastro modoCadastro = ModoCadastro.IMPORTACAO;
        ent.setModoCadastro(modoCadastro);
        
        LocalDateTime dataCadastro = LocalDateTime.now();
        ent.setDataCadastro(dataCadastro);
        
        Usuario user = null;
        ent.setUsuario(user);
        
        TipoEntidade tipoPessoa = verificaPessoa(entidadeElem);
        ent.setTipo(tipoPessoa);
        
        String cpfCnpj = verificaCpfCnpj(entidadeElem, tipoPessoa);
        ent.setCpfCnpj(Long.parseLong(cpfCnpj));

        return ent;
    }

    public List<Produto> produtosNota(Element prods) {

        List<Produto> produtoList = null;

        int ncm;
        Long codigo;
        String descricao;
        String tipo = null;
        String unidadeSigla;
        boolean permiteFracionar = true;

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

            produtoList.add(produto);
            dao.save(produto);

        }
        return produtoList;

    }

    public Produto cadastrarProduto(String descricao, UnidadeMedida unidade, boolean permiteFracionar, String tipo, int codigoNcm, Categoria categoria) {
        Produto produto;

        List<Produto> produtoList = dao.buscarPorPropriedade(Produto.class, "descricao", descricao, MatchMode.EXACT);

        if (produtoList.isEmpty()) {
            produto = new Produto(descricao, unidade, permiteFracionar, tipo, codigoNcm, categoria);
        } else {
            produto = produtoList.get(0);
        }

        dao.save(produto);
        return produto;
    }

    public UnidadeMedida cadastrarUnidade(String unidadeSigla) {
        UnidadeMedida unidade;

        List<UnidadeMedida> unidadeList = dao.buscarPorPropriedade(UnidadeMedida.class, "sigla", unidadeSigla, MatchMode.EXACT);

        if (unidadeList.isEmpty()) {
            unidade = new UnidadeMedida(unidadeSigla, unidadeSigla);
        } else {
            unidade = unidadeList.get(0);
        }
        dao.save(unidade);
        return unidade;
    }

    public Categoria cadastrarCategoria(String categoriaDesc) {
        Categoria categoria;

        List<Categoria> categoriaList = dao.buscarPorPropriedade(Categoria.class, "nome", categoriaDesc, MatchMode.EXACT);

        if (categoriaList.isEmpty()) {
            categoria = new Categoria(categoriaDesc);
        } else {
            categoria = categoriaList.get(0);
        }
        dao.save(categoria);
        return categoria;
    }

    public TipoEntidade verificaPessoa(Element entidadeElem) {
        if (entidadeElem.select(":containsOwn(CNPJ)") == null) {
            return TipoEntidade.FÍSICA;
        }
        return TipoEntidade.JURIDICA;
    }

    public String verificaCpfCnpj(Element entidadeElem, TipoEntidade tipo) {
        if (tipo == TipoEntidade.FÍSICA) {
            return entidadeElem.select(":containsOwn(CNPJ)").first().parent().child(1).text();
        } else {
            return entidadeElem.select(":containsOwn(CPF)").first().parent().child(1).text();
        }

    }

    public String retornaElemento(Element el, String campo) {
        return el.select(":containsOwn(" + campo + ")").first().parent().child(1).text();
    }
}
