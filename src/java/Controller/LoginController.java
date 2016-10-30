package Controller;

import dao.DAOGenerica;
import entity.entitys.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.criterion.MatchMode;

/**
 *
 * @author Hygor Azevedo
 */
public class LoginController extends HttpServlet {

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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOGenerica dao = new DAOGenerica();
        List<Usuario> usuarios = dao.buscarPorPropriedade(Usuario.class, "login", request.getParameter("usuario"), MatchMode.EXACT);
        if(usuarios.size()>0)
        {
            if(usuarios.get(0).getSenha().equals(request.getParameter("senha"))){
            
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuarios.get(0).getLogin());
                response.sendRedirect("index.jsp");
            }
            else
            {
                request.setAttribute("message", "Conta inválida!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
