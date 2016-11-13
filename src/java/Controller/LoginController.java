package Controller;

import entity.entitys.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.criterion.MatchMode;

public class LoginController extends ControllerGenerica {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> usuarios = dao.buscarPorPropriedade(Usuario.class, "login", request.getParameter("usuario"), MatchMode.EXACT);
        if(usuarios.size()>0 && usuarios.get(0).getSenha().equals(request.getParameter("senha")))
        {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuarios.get(0).getNome());
            response.sendRedirect("index.jsp");
        }
        else
        {
            String msg = "<div class=\"container\">";
            msg += "<div class=\"alert alert-danger\">";
            msg += "<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>";
            msg += "<center>Conta inválida!</center></div></div>";
            request.setAttribute("message", msg);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
