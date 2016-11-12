package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.entitys.Entidade;
import entity.entitys.Movimentacao;
import entity.enums.ModoCadastro;
import entity.enums.TipoEntidade;
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
public class EntidadeController extends ControllerGeneric {

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
        montarEntidade(obj);
        dao.save(entidade);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());
        entidade = (Entidade) dao.buscarPorId(Entidade.class, obj.get("id").getAsLong());
        montarEntidade(obj);
        dao.update(entidade);

    }

    private void montarEntidade(JsonObject obj) throws IOException {
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
        String tipoLogadouro = obj.get("tipoLogadouro").getAsString();
        if (!tipoLogadouro.equals("")) {
            entidade.getEndereco().setTipo_logadouro(TipoLogadouro.valueOf(tipoLogadouro));
        }
        entidade.getEndereco().setLogadouro(obj.get("logadouro").getAsString());
        entidade.getEndereco().setNumero(obj.get("numero").getAsInt());
        entidade.getEndereco().setBairro(obj.get("bairro").getAsString());
        entidade.getEndereco().setCidade(obj.get("cidade").getAsString());
        entidade.getEndereco().setEstado(obj.get("estado").getAsString());
        entidade.setModoCadastro(ModoCadastro.MANUALMENTE);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            dao.delete(Movimentacao.class, Long.parseLong(request.getParameter("id")));
        } catch (NotFoundException ex) {
            Logger.getLogger(UnidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
