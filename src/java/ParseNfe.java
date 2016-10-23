
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import dao.DAOGenerica;
import entity.entitys.*;
import java.util.List;
import org.hibernate.criterion.MatchMode;

/**
 *
 * @author Gustavo
 */
public class ParseNfe {

    private static DAOGenerica dao = new DAOGenerica();

    String nfe_html;
    Document doc;
    Document prod;

    public ParseNfe(String nfe_html) {
        this.nfe_html = nfe_html;
    }

    public void rodar() {

    }

    public List<Produto> produtosNota() {

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

        doc = Jsoup.parse(nfe_html, "UTF-8", Parser.xmlParser());
        Element prods = doc.select("#Prod").first();
        Elements boxes = prods.children().first().child(1).children();
        boxes.remove(0);

        for (int i = 0; i < boxes.size(); i = i + 2) {

            prodHeader = boxes.get(i);
            prodContent = boxes.get(i + 1);

            unidadeSigla = prodHeader.select(".fixo-prod-serv-uc").text();

            descricao = prodHeader.select(".fixo-prod-serv-descricao").text();

            codigo = Long.parseLong(prodContent.select(":containsOwn(Código do Produto)").first().parent().child(1).text());
            ncm = Integer.parseInt(prodContent.select(":containsOwn(Código NCM)").first().parent().child(1).text());
            
            unidade = cadastrarUnidade(unidadeSigla);
            produto = cadastrarProduto(codigo, descricao, unidade, permiteFracionar, tipo, ncm, categoria);
            produtoList.add(produto);
            dao.save(produto);

        }
        return produtoList;

    }

    public Produto cadastrarProduto(Long id, String descricao, UnidadeMedida unidade, boolean permiteFracionar, String tipo, int codigoNcm, Categoria categoria) {
        Produto produto;

        List<Produto> produtoList = dao.buscarPorPropriedade(Produto.class, "descricao", descricao, MatchMode.EXACT);

        if (produtoList.isEmpty()) {
            produto = new Produto(id, descricao, unidade, permiteFracionar, tipo, codigoNcm, categoria);
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

}
