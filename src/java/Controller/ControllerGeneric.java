/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import dao.DAOGenerica;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruna
 */
public abstract class ControllerGeneric extends HttpServlet {

    protected static final DAOGenerica dao = new DAOGenerica();

    @Override
    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    @Override
    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    @Override
    protected abstract void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    @Override
    protected abstract void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

}
