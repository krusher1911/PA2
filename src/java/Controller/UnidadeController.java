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
import entity.entitys.UnidadeMedida;
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
public class UnidadeController extends HttpServlet {

    private static final DAOGenerica dao = new DAOGenerica();
    private UnidadeMedida unidade;
    boolean isValid = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, Object> map = new HashMap<String, Object>();
        if (request.getParameter("id").equals("")) {
            List<UnidadeMedida> unidades = dao.buscarTudo(UnidadeMedida.class);
            if (!unidades.isEmpty()) {
                map.put("unidades", unidades);
                isValid = true;
            }
        } else {
            unidade = (UnidadeMedida) dao.buscarPorId(UnidadeMedida.class, Long.parseLong(request.getParameter("id")));
            map.put("unidade", unidade);
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
        unidade = new UnidadeMedida();
        unidade.setDescricao(obj.get("descricao").getAsString());
        unidade.setSigla(obj.get("sigla").getAsString());
        dao.save(unidade);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());
        unidade = (UnidadeMedida) dao.buscarPorId(UnidadeMedida.class, obj.get("id").getAsLong());
        unidade.setDescricao(obj.get("descricao").getAsString());
        unidade.setSigla(obj.get("sigla").getAsString());
        dao.update(unidade);

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            dao.delete(UnidadeMedida.class, Long.parseLong(request.getParameter("id")));
        } catch (NotFoundException ex) {
            Logger.getLogger(UnidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
