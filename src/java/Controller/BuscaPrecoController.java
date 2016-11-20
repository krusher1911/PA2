package Controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.entitys.Produto;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Bruna
 */
public class BuscaPrecoController extends ControllerGenerica {

    private Produto produto;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String url = montaURL((JsonObject) new JsonParser().parse(request.getReader()));
        procurarValores(url);
    }

    private String montaURL(JsonObject obj) throws UnsupportedEncodingException {
        produto = (Produto) dao.buscarPorId(Produto.class, obj.get("id").getAsLong());
        Queue filaUrl = new LinkedList();
        filaUrl.addAll(Arrays.asList("http://www.jacotei.com.br/busca/?texto="));
        String url = (String) filaUrl.poll();
        url = url.concat(URLEncoder.encode(trocaPalavras(), "UTF-8"));

        return url;
    }

    private String trocaPalavras() {
        String descricao = produto.getDescricao().toUpperCase();
        descricao = descricao.replace("MOTO", "MOTOROLA");
        descricao = descricao.replace("NEW", "");
        descricao = descricao.replace("-", "");

        return descricao;
    }

    private void procurarValores(String url) throws IOException {
        Document doc = Jsoup.parse(new URL(url).openStream(), "utf-8", url);

        String menor = doc.select("article:lt(1) > div:eq(4) > p:eq(0) > a > span > strong").text();
        String maior = doc.select("article:lt(1) > div:eq(4) >  p:eq(1) > a > span").text();

        Double minimo = Double.parseDouble(menor.substring(3).replace(".", "").replace(",", "."));
        Double maximo = Double.parseDouble(maior.substring(3).replace(".", "").replace(",", "."));

        atualizarProduto(minimo, maximo, url);
    }

    private void atualizarProduto(Double valorMinimo, Double valorMaximo, String url) {
        produto.setValorMinimo(valorMinimo);
        produto.setValorMaximo(valorMaximo);
        produto.setLink(url);
        dao.update(produto);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
