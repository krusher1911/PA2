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
import entity.entitys.Entidade;
import entity.entitys.NotaFiscal;
import entity.enums.ModoCadastro;
import entity.enums.Natureza;
import entity.enums.TipoNota;
import java.io.IOException;
import java.util.Date;
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
public class NotaFiscalController extends HttpServlet {

    private static final DAOGenerica dao = new DAOGenerica();
    private NotaFiscal notaFiscal;
    boolean isValid = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (request.getParameter("id").equals("")) {
        List<NotaFiscal> notasFiscais = dao.buscarTudo(NotaFiscal.class);
            if (!notasFiscais.isEmpty()) {
                map.put("notasFiscais", notasFiscais);
                isValid = true;
            }
        } else {
            notaFiscal = (NotaFiscal) dao.buscarPorId(NotaFiscal.class, Long.parseLong(request.getParameter("id")));
            map.put("notaFiscal", notaFiscal);
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
        notaFiscal = new NotaFiscal();
        montarNotaFiscal(obj);
        dao.save(notaFiscal);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());
        notaFiscal = (NotaFiscal) dao.buscarPorId(NotaFiscal.class, obj.get("id").getAsLong());
        montarNotaFiscal(obj);
        dao.update(notaFiscal);

    }

    private void montarNotaFiscal(JsonObject obj) throws IOException {
        notaFiscal.setEmissao(new Date(obj.get("emissao").toString()));
        notaFiscal.setValorTotal(obj.get("valorTotal").getAsDouble());
        Long entidade = obj.get("entidade").getAsLong();
        if (entidade != null) {
            notaFiscal.setEntidade((Entidade) dao.buscarPorId(Entidade.class, entidade));
        }
        notaFiscal.setNumero(obj.get("numero").getAsLong());
        notaFiscal.setSerie(obj.get("serie").getAsString());
        if (obj.get("tipo").getAsString().equalsIgnoreCase("E")) {
            notaFiscal.setTipo(TipoNota.ENTRADA);
        } else {
            notaFiscal.setTipo(TipoNota.SAíDA);
        }

        switch (obj.get("natureza").getAsCharacter()) {
            case 'B':
                notaFiscal.setNatureza(Natureza.BONIFICAÇÃO);
            case 'D':
                notaFiscal.setNatureza(Natureza.DEVOLUÇÃO);
            case 'V':
                notaFiscal.setNatureza(Natureza.VENDA);
        }
        notaFiscal.setModoCadastro(ModoCadastro.MANUALMENTE);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            dao.delete(NotaFiscal.class, Long.parseLong(request.getParameter("id")));
        } catch (NotFoundException ex) {
            Logger.getLogger(UnidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
