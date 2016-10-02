package servlet;

import coletor.ColetorReceita;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author Gustavo
 */
@WebServlet(name = "Receita", urlPatterns = {"/Receita"})
public class ServletGetReceita extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        ColetorReceita coletor2 = new ColetorReceita();
        coletor2.rodar();
        
        response.addCookie(coletor2.getCookie_session());
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Receita</title>");
            out.println("<link href=\"css/main.css\"rel=\"stylesheet\"type=\"text/css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form name=\"form_coletor\" action=\"posteceita\" method=\"POST\">");
            out.println("   <table class=\"tg\">");
            out.println("   <tr>");
            out.println("       <th rowspan=\"2\">" + coletor2.getElementoPorID("#ctl00_ContentPlaceHolder1_imgCaptcha") + "</th>");
            out.println("       <th colspan=\"2\">"+ coletor2.getElementoPorID("#ctl00_ContentPlaceHolder1_txtChaveAcessoCompleta") + "</th>");
            out.println("     </tr>");
            out.println("     <tr>");
            out.println("       <td colspan=\"2\">"+ coletor2.getElementoPorID("#ctl00_ContentPlaceHolder1_txtCaptcha") + "</td>");
            out.println("     </tr>");
            out.println("     <tr>");
            out.println("       <td></td>");
            out.println("       <td>" + coletor2.getElementoPorID("#ctl00_ContentPlaceHolder1_btnConsultar") + " " +  coletor2.getElementoPorID("#ctl00_ContentPlaceHolder1_btnLimpar") + "</td>");
            out.println("       <td></td>");
            out.println("     </tr>");
            out.println(    "</table>");
            out.println("</from>");
            out.println(coletor2.getElementoPorID("[name=__VIEWSTATE]"));
            out.println(coletor2.getElementoPorID("[name=__VIEWSTATEGENERATOR]"));
            out.println(coletor2.getElementoPorID("[name=__EVENTVALIDATION]"));
            out.println(coletor2.getElementoPorID("#ctl00_ContentPlaceHolder1_token"));
            out.println(coletor2.getElementoPorID("#ctl00_ContentPlaceHolder1_captchaSom"));
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
