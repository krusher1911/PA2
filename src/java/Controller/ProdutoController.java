package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.entitys.Categoria;
import entity.entitys.Produto;
import entity.entitys.UnidadeMedida;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javassist.NotFoundException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdutoController extends ControllerGeneric {

    private Produto produto;
    boolean isValid = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (request.getParameter("id").equals("")) {
            List<Produto> produtos = dao.buscarTudo(Produto.class);
            if (!produtos.isEmpty()) {
                map.put("produtos", produtos);
                isValid = true;
            }
        } else {
            produto = (Produto) dao.buscarPorId(Produto.class, Long.parseLong(request.getParameter("id")));
            map.put("produto", produto);
            isValid = true;
        }
        map.put("isValid", isValid);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        produto = new Produto();
        JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());
        montarProduto(request, obj);
        dao.save(produto);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());
        produto = (Produto) dao.buscarPorId(Produto.class, obj.get("id").getAsLong());
        montarProduto(request, obj);
        dao.update(produto);

    }
    
    private void montarProduto(HttpServletRequest request, JsonObject obj) throws IOException {
        produto.setDescricao(obj.get("descricao").getAsString());
        Long unidade = obj.get("unidade").getAsLong();
        if (!unidade.equals("")) {
            produto.setUnidade((UnidadeMedida) dao.buscarPorId(UnidadeMedida.class, unidade));
        }
        produto.setPermiteFracionar(obj.get("permiteFracionar").getAsBoolean());
        produto.setTipo(obj.get("tipo").getAsString());
        produto.setCodigNcm(obj.get("codigoNcm").getAsInt());
        Long categoria = obj.get("categoria").getAsLong();
        if (!categoria.equals("")) {
            produto.setCategoria((Categoria) dao.buscarPorId(Categoria.class, categoria));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            dao.delete(Produto.class, Long.parseLong(request.getParameter("id")));
        } catch (NotFoundException ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
