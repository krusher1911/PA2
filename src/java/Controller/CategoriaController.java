/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.DAOGenerica;
import entity.entitys.Categoria;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javassist.NotFoundException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruna
 */
public class CategoriaController extends HttpServlet {

    private static final DAOGenerica dao = new DAOGenerica();
    private Categoria categoria;
    boolean isValid = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, Object> map = new HashMap<String, Object>();
        if (request.getParameter("id").equals("")) {
            List<Categoria> categorias = dao.buscarTudo(Categoria.class);
            if (!categorias.isEmpty()) {
                map.put("categorias", categorias);
                isValid = true;
            }
        } else {
            categoria = (Categoria) dao.buscarPorId(Categoria.class, Long.parseLong(request.getParameter("id")));
            map.put("categoria", categoria);
            isValid = true;
        }
        map.put("isValid", isValid);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());
        categoria = new Categoria();
        categoria.setNome(obj.get("nome").getAsString());
        dao.save(categoria);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());
        categoria = (Categoria) dao.buscarPorId(Categoria.class, obj.get("id").getAsLong());
        categoria.setNome(obj.get("nome").getAsString());
        dao.update(categoria);

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            dao.delete(Categoria.class, Long.parseLong(request.getParameter("id")));
        } catch (NotFoundException ex) {
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
