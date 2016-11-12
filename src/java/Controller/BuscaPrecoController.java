package Controller;

import coletor.ColetorBusca;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.entitys.Produto;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruna
 */
public class BuscaPrecoController extends ControllerGenerica {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Produto produto = (Produto) dao.buscarPorId(Produto.class, Long.parseLong(request.getParameter("id")));
        Queue fila = new LinkedList();
        fila.addAll(Arrays.asList("http://www.jacotei.com.br/busca/?texto="));

        ColetorBusca coletor = new ColetorBusca();
        coletor.setProduto(produto);
        coletor.setFilaUrls(fila);
        coletor.coletar();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());
        request.setCharacterEncoding("UTF-8");
        Produto produto = (Produto) dao.buscarPorId(Produto.class, obj.get("id").getAsLong());
        Queue fila = new LinkedList();
        fila.addAll(Arrays.asList("http://www.jacotei.com.br/busca/?texto="));

        ColetorBusca coletor = new ColetorBusca();
        coletor.setProduto(produto);
        coletor.setFilaUrls(fila);
        coletor.coletar();

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
