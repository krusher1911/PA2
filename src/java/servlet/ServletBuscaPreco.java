/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package servlet;

import coletor.ColetorBusca;
import dao.DAOGenerica;
import entity.entitys.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruna
 */
public class ServletBuscaPreco extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Long idProduto = Long.parseLong(request.getParameter("idProduto"));
        Produto produto = (Produto) new DAOGenerica().buscarPorId(Produto.class, idProduto);
        Queue fila = new LinkedList();
        fila.addAll(Arrays.asList("http://www.jacotei.com.br/busca/?texto="));

        ColetorBusca coletor = new ColetorBusca();
        coletor.setProduto(produto);
        coletor.setFilaUrls(fila);
        coletor.coletar();

        try {
            out.println("<html>");
            out.println("  <head>");
            out.println("    <title>Coletor</title>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("  </head>");
            out.println("  <body>");
            out.println("    <h1>Coletor</h1>");
            out.println("    <div >");
            out.println("      Inicio: <br/> Coletou e armazenou ! <br/>  Fim!");
            out.println("    </div>");
            out.println("  </body>");
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
