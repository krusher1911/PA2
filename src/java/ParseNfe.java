
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import dao.DAOGenerica;
import entity.entitys.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class ParseNfe {

    String nfe_html;
    Document doc;
    Document prod;

    public ParseNfe(String nfe_html) {
        this.nfe_html = nfe_html;
    }

    public void rodar() {
        //cadastrarUnidade();
        cadastrarProdutos();

    }

    public void cadastrarProdutos() {
        String codigo;
        int ncm;
        String descricao;
        String tipo = null;
        UnidadeMedida unidade = new UnidadeMedida();
        Categoria categoria = new Categoria("importacao");
        boolean permiteFracionar = true;
        Produto produto;

        Elements tableTemp;
        Element prodHeader;
        Element prodContent;

        doc = Jsoup.parse(nfe_html, "UTF-8", Parser.xmlParser());
        Element prods = doc.select("#Prod").first();
        Elements boxes = prods.children().first().child(1).children();
        boxes.remove(0);

        for (int i = 0; i < boxes.size(); i = i + 2) {
            prodHeader = boxes.get(i);
            prodContent = boxes.get(i + 1);

            descricao = prodHeader.select(".fixo-prod-serv-descricao").text();
            //unidade = prodHeader.select(".fixo-prod-serv-uc").text();

            codigo = prodContent.select(":containsOwn(Código do Produto)").first().parent().child(1).text();
            ncm = Integer.parseInt(prodContent.select(":containsOwn(Código NCM)").first().parent().child(1).text());

            produto = new Produto(descricao, unidade, permiteFracionar, tipo, ncm, categoria);

        }
    }

}
