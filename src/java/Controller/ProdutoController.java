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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hygor Azevedo
 */
public class ProdutoController extends HttpServlet {

    private static final DAOGenerica dao = new DAOGenerica();
    private Produto produto;
    boolean isValid = false;
    // <editor-fold defaultstate="collapsed" desc="Javadoc GET">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */// </editor-fold>
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

    // <editor-fold defaultstate="collapsed" desc="Javadoc POST">
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */// </editor-fold>
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());
        produto = new Produto();
        montarProduto(request, obj);
        dao.save(produto);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());

        produto = (Produto) dao.buscarPorId(Produto.class, Long.parseLong(obj.get("id").toString()));
        montarProduto(request, obj);
        dao.update(produto);

    }

    private void montarProduto(HttpServletRequest request, JsonObject obj) throws IOException {

        produto.setDescricao(obj.get("descricao").getAsString());
        String unidade = obj.get("unidade").getAsString();
        if (!unidade.equals("")) {
            produto.setUnidade((UnidadeMedida) dao.buscarPorId(UnidadeMedida.class, Long.parseLong(unidade)));
        }
        produto.setPermiteFracionar(Boolean.parseBoolean(obj.get("permiteFracionar").getAsString()));
        produto.setTipo(obj.get("tipo").getAsString());
        produto.setCodigNcm(obj.get("codigoNcm").getAsInt());
        String categoria = obj.get("categoria").getAsString();
        if (!categoria.equals("")) {
            produto.setCategoria((Categoria) dao.buscarPorId(Categoria.class, Long.parseLong(categoria)));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
