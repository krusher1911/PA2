package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.DAOGenerica;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdutoController extends HttpServlet {

    private static final DAOGenerica dao = new DAOGenerica();
    private Produto produto;
    boolean isValid = false;

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

        JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());
        produto = new Produto();

        if (request.getParameter("del").equals("false")){
            produto.setDescricao(request.getParameter("descricao"));
            String unidade = request.getParameter("unidades");
            if (!unidade.equals("")) {
                produto.setUnidade((UnidadeMedida) dao.buscarPorId(UnidadeMedida.class, Long.parseLong(unidade)));
            }
            produto.setPermiteFracionar(Boolean.parseBoolean(request.getParameter("permiteFracionar")));
            produto.setTipo(request.getParameter("tipo"));
            produto.setCodigNcm(Integer.parseInt(request.getParameter("codigoNcm")));
            String categoria = request.getParameter("categorias");
            if (!categoria.equals("")) {
                produto.setCategoria((Categoria) dao.buscarPorId(Categoria.class, Long.parseLong(categoria)));
            }
            montarProduto(request, obj);
            dao.save(produto);
        }
        else{
            produto = (Produto) dao.buscarPorId(Produto.class, Long.parseLong(request.getParameter("id")));
            try {
                dao.delete(produto.getClass(), Long.parseLong(request.getParameter("id")));
            } catch (NotFoundException ex) {
                Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("index.jsp");
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
