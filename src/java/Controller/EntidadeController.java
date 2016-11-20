package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.entitys.Endereco;
import entity.entitys.Entidade;
import entity.enums.ModoCadastro;
import entity.enums.TipoEntidade;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javassist.NotFoundException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruna
 */
public class EntidadeController extends ControllerGenerica {

    private Entidade entidade;
    boolean isValid = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (request.getParameter("id").equals("")) {
            List<Entidade> entidades = dao.buscarTudo(Entidade.class);
            if (!entidades.isEmpty()) {
                map.put("entidades", entidades);
                isValid = true;
            }
        } else {
            entidade = (Entidade) dao.buscarPorId(Entidade.class, Long.parseLong(request.getParameter("id")));
            map.put("entidade", entidade);
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
        entidade = new Entidade();
        montarEntidade(obj, request, response);
        dao.save(entidade);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());
        entidade = (Entidade) dao.buscarPorId(Entidade.class, obj.get("id").getAsLong());
        montarEntidade(obj, request, response);
        dao.update(entidade);

    }

    private void montarEntidade(JsonObject obj, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tipoEntidade = obj.get("tipoEntidade").getAsString();
        if (!tipoEntidade.equals("")) {
            entidade.setTipo(TipoEntidade.valueOf(tipoEntidade));
        }
        entidade.setNome(obj.get("nome").getAsString());
        if (tipoEntidade.equals("FÍSICA")) {
            entidade.setApelido(obj.get("apelido").getAsString());
        } else {
            entidade.setNomeFantasia(obj.get("nomeFantasia").getAsString());
        }
        entidade.setCpfCnpj(obj.get("cnpjCpf").getAsLong());
        entidade.setEndereco(new Endereco());
        request.setAttribute("id", entidade.getEndereco().getId());
        new EnderecoController().doPut(request, response);
        entidade.setModoCadastro(ModoCadastro.MANUALMENTE);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            dao.delete(Entidade.class, Long.parseLong(request.getParameter("id")));
        } catch (NotFoundException ex) {
            Logger.getLogger(UnidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
