package Controller;

import dao.DAOGenerica;
import entity.entitys.Categoria;
import entity.entitys.Produto;
import entity.entitys.UnidadeMedida;
import java.io.IOException;
import java.util.List;
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

        DAOGenerica dao = new DAOGenerica();
        List<Produto> produtos = dao.buscarTudo(Produto.class);

        HttpSession session = request.getSession();
        session.setAttribute("produtos", produtos);

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

        DAOGenerica dao = new DAOGenerica();

        Produto produto = new Produto();
        produto.setDescricao(request.getParameter("descricao"));
        UnidadeMedida unidade = (UnidadeMedida) dao.buscarPorId(Produto.class, Long.parseLong(request.getParameter("unidade")));
        produto.setUnidade(unidade);
        produto.setPermiteFracionar(Boolean.parseBoolean(request.getParameter("permiteFracionar")));
        produto.setTipo(request.getParameter("tipo"));
        produto.setCodigNcm(Integer.parseInt(request.getParameter("codigoNcm")));
        Categoria categoria = (Categoria) dao.buscarPorId(Categoria.class, Long.parseLong(request.getParameter("categoria")));
        produto.setCategoria(categoria);

        dao.save(produto);

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
