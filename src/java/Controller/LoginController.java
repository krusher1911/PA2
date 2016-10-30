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

public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

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
        if(usuarios.size()>0 && usuarios.get(0).getSenha().equals(request.getParameter("senha")))
        {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuarios.get(0).getLogin());
            response.sendRedirect("index.jsp");
        }
        else
        {
            String msg = "<div id=" + '"' +"+loginErro" + '"' +"class=" + '"' + "alert alert-danger alert-dismissible" + '"' + "role="+'"'+"alert"+'"'+ ">";
            msg += "<a href="+'"'+"#"+'"'+"class="+'"'+"close"+'"'+"data-dismiss="+'"'+"alert"+'"'+"aria-label="+'"'+"close"+'"'+">&times;</a>";
            msg += "<center>Conta inválida!</center>";
            msg += "</div>";
            request.setAttribute("message", msg);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
