package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.entitys.Endereco;
import entity.enums.TipoLogadouro;
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
public class EnderecoController extends ControllerGenerica {

    private Endereco endereco;
    boolean isValid = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (request.getParameter("id").equals("")) {
            List<Endereco> enderecos = dao.buscarTudo(Endereco.class);
            if (!enderecos.isEmpty()) {
                map.put("enderecos", enderecos);
                isValid = true;
            }
        } else {
            endereco = (Endereco) dao.buscarPorId(Endereco.class, Long.parseLong(request.getParameter("id")));
            map.put("endereco", endereco);
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
        endereco = new Endereco();
        montarEndereco(obj);
        dao.save(endereco);
        Long id = endereco.getId();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());
        endereco = (Endereco) dao.buscarPorId(Endereco.class, obj.get("id").getAsLong());
        montarEndereco(obj);
        dao.update(endereco);

    }

    private void montarEndereco(JsonObject obj) throws IOException {
        String tipoLogadouro = obj.get("tipoLogadouro").getAsString();
        if (!tipoLogadouro.equals("")) {
            endereco.setTipo_logadouro(TipoLogadouro.valueOf(tipoLogadouro));
        }
        endereco.setLogadouro(obj.get("logadouro").getAsString());
        endereco.setNumero(obj.get("numero").getAsInt());
        endereco.setBairro(obj.get("bairro").getAsString());
        endereco.setCidade(obj.get("cidade").getAsString());
        endereco.setEstado(obj.get("estado").getAsString());
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            dao.delete(Endereco.class, Long.parseLong(request.getParameter("id")));
        } catch (NotFoundException ex) {
            Logger.getLogger(UnidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
