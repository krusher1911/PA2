package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.entitys.Movimentacao;
import entity.entitys.NotaFiscal;
import entity.entitys.Produto;
import entity.entitys.UnidadeMedida;
import entity.enums.ModoCadastro;
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
public class MovimentacaoController extends ControllerGenerica {

    private Movimentacao movimentacao;
    boolean isValid = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (request.getParameter("id").equals("")) {
            List<Movimentacao> movimentacoes = dao.buscarTudo(Movimentacao.class);
            if (!movimentacoes.isEmpty()) {
                map.put("movimentacoes", movimentacoes);
                isValid = true;
            }
        } else {
            movimentacao = (Movimentacao) dao.buscarPorId(Movimentacao.class, Long.parseLong(request.getParameter("id")));
            map.put("movimentacao", movimentacao);
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
        movimentacao = new Movimentacao();
        montarMovimentacao(obj);
        dao.save(movimentacao);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());

        movimentacao = (Movimentacao) dao.buscarPorId(Movimentacao.class, obj.get("id").getAsLong());
        montarMovimentacao(obj);
        dao.update(movimentacao);

    }

    private void montarMovimentacao(JsonObject obj) throws IOException {
        Long produto = obj.get("produto").getAsLong();
        if (produto != null) {
            movimentacao.setProduto((Produto) dao.buscarPorId(Produto.class, produto));
        }
        movimentacao.setQuantidade(obj.get("quantidade").getAsInt());
        Long unidade = obj.get("unidade").getAsLong();
        if (unidade != null) {
            movimentacao.setUnidade((UnidadeMedida) dao.buscarPorId(UnidadeMedida.class, unidade));
        }
        JsonElement notaFiscal = obj.get("notaFiscal");
        if (notaFiscal != null) {
            movimentacao.setNotaFiscal((NotaFiscal) dao.buscarPorId(NotaFiscal.class, notaFiscal.getAsLong()));
        }
        movimentacao.setTotal(obj.get("total").getAsDouble());
        movimentacao.setUnitario(obj.get("unitario").getAsDouble());
        movimentacao.setDesconto(obj.get("desconto").getAsDouble());
        movimentacao.setModoCadastro(ModoCadastro.MANUALMENTE);
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
