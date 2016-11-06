/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import coletor.ParseNfe;
import coletor.ConectorReceita;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/**
 *
 * @author Gustavo
 */
@WebServlet(name = "ServletPostReceita", urlPatterns = {"/ServletPostReceita"})
public class ServletPostReceita extends HttpServlet {

    private Document doc;

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

        String[] parametros = new String[12];
        String[] nome_parametros = new String[12];
        String resposta = null;
        Elements prod = null;

        //ToDo: estudar a utilizacao do getParameterValues() para a variavel parametros
        nome_parametros[0] = "__EVENTTARGET";
        parametros[0] = "";

        nome_parametros[1] = "__EVENTARGUMENT";
        parametros[1] = "";

        nome_parametros[2] = "__VIEWSTATE";
        parametros[2] = request.getParameter("__VIEWSTATE");

        nome_parametros[3] = "__VIEWSTATEGENERATOR";
        parametros[3] = request.getParameter("__VIEWSTATEGENERATOR");

        nome_parametros[4] = "__EVENTVALIDATION";
        parametros[4] = request.getParameter("__EVENTVALIDATION");

        nome_parametros[5] = "ctl00$txtPalavraChave";
        parametros[5] = "";

        nome_parametros[6] = "ctl00$ContentPlaceHolder1$txtChaveAcessoCompleta";
        parametros[6] = request.getParameter("ctl00$ContentPlaceHolder1$txtChaveAcessoCompleta");

        nome_parametros[7] = "ctl00$ContentPlaceHolder1$txtCaptcha";
        parametros[7] = request.getParameter("ctl00$ContentPlaceHolder1$txtCaptcha");

        nome_parametros[8] = "ctl00$ContentPlaceHolder1$btnConsultar";
        parametros[8] = request.getParameter("ctl00$ContentPlaceHolder1$btnConsultar");

        nome_parametros[9] = "ctl00$ContentPlaceHolder1$token";
        parametros[9] = request.getParameter("ctl00$ContentPlaceHolder1$token");

        nome_parametros[10] = "ctl00$ContentPlaceHolder1$captchaSom";
        parametros[10] = request.getParameter("ctl00$ContentPlaceHolder1$captchaSom");

        nome_parametros[11] = "hiddenInputToUpdateATBuffer_CommonToolkitScripts";
        parametros[11] = "1";

        Cookie[] cookies = request.getCookies();

        ConectorReceita conector = new ConectorReceita();

        PrintWriter out = response.getWriter();

        try {
            resposta = conector.sendPost(cookies[0], parametros, nome_parametros);
            
            doc = Jsoup.parse(resposta, "UTF-8", Parser.xmlParser());
            prod = doc.select("#Prod");

        } catch (Exception e) {
            // Always must return something
            System.out.println(e);
        }
        
        ParseNfe teste = new ParseNfe(resposta);
        teste.rodar();
        try {
            /* TODO output your page here. You may use following sample code. */
            if ("".equals(prod.toString())) {
                out.print("Erro");
                RequestDispatcher rd = request.getRequestDispatcher("Receita");
                rd.include(request, response);
                System.out.println("teste");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletPostReceita</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("\"" + prod.toString() + "\"");
                out.println("<h1>Servlet ServletPostReceita at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (Exception e) {
            // Always must return something
            System.out.println(e);
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
