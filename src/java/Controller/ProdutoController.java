package Controller;

import com.google.gson.Gson;
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
import javax.servlet.http.HttpSession;

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

        List<Produto> produtos = dao.buscarTudo(Produto.class);
        if (!produtos.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("produtos", produtos);
            isValid = true;
        }
        Map<String, Object> map = new HashMap<String, Object>();
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

        produto = new Produto();
        produto.setDescricao(request.getParameter("descricao"));
        String unidade = request.getParameter("unidades");
        if (!unidade.equals("")) {
            produto.setUnidade((UnidadeMedida) dao.buscarPorId(Produto.class, Long.parseLong(unidade)));
        }
        produto.setPermiteFracionar(Boolean.parseBoolean(request.getParameter("permiteFracionar")));
        produto.setTipo(request.getParameter("tipo"));
        produto.setCodigNcm(Integer.parseInt(request.getParameter("codigoNcm")));
        String categoria = request.getParameter("categorias");
        if (!categoria.equals("")) {
            produto.setCategoria((Categoria) dao.buscarPorId(Categoria.class, Long.parseLong(categoria)));
        }

        dao.save(produto);
        response.sendRedirect("index.jsp");

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        produto = (Produto) dao.buscarPorId(Produto.class, Long.parseLong(request.getParameter("id")));

        produto.setDescricao(request.getParameter("descricao"));
        String unidade = request.getParameter("unidade");
        if (!unidade.equals("")) {
            produto.setUnidade((UnidadeMedida) dao.buscarPorId(Produto.class, Long.parseLong(unidade)));
        }
        produto.setPermiteFracionar(Boolean.parseBoolean(request.getParameter("permiteFracionar")));
        produto.setTipo(request.getParameter("tipo"));
        produto.setCodigNcm(Integer.parseInt(request.getParameter("codigoNcm")));
        String categoria = request.getParameter("categoria");
        if (!categoria.equals("")) {
            produto.setCategoria((Categoria) dao.buscarPorId(Categoria.class, Long.parseLong(categoria)));
        }

        dao.update(produto);
        response.sendRedirect("index.jsp");

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
