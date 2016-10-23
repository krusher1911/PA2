
import dao.DAOGenerica;
import entity.entitys.*;

/**
 *
 * @author Bruna
 */
public class Testes {

    private static DAOGenerica dao = new DAOGenerica();

    public static void main(String[] args) {

//        //testar uma nota fiscal com cadastro de movimentacao, produto, usuario, unidade medida, cliente, endereco
        Categoria categoria = new Categoria("cateforia");
        dao.save(categoria);

        UnidadeMedida unidade = new UnidadeMedida("litro", "1");
        dao.save(unidade);

        Produto produto = new Produto();
        produto.setDescricao("produto sim");
        produto.setCategoria(categoria);
        produto.setUnidade(unidade);
        dao.save(produto);

        Produto produtoBuscado = (Produto) dao.buscarPorId(Produto.class, produto.getId());
        System.out.println(produtoBuscado.getCategoria());

//
//        Usuario usuario = new Usuario();
//        usuario.setLogin("angelino");
//        dao.save(usuario);
//
//        Endereco endereco = new Endereco();
//        endereco.setLogadouro("arqi");
//        dao.save(endereco);
//
//        Entidade entidade = new Cliente();
//        entidade.setEndereco(endereco);
//        entidade.setUsuario(usuario);
//        dao.save(entidade);
//
//        NotaFiscal c1 = new NotaFiscal();
//        c1.setEntidade(entidade);
//        c1.setChave("qualquercoisa");
//        c1.setUsuario(usuario);
//        dao.save(c1);
//
//        ArrayList itens = new ArrayList();
//        itens.add(new Movimentacao(produto, 0, unidade, c1, 0, 0, 0, ModoCadastro.IMPORTACAO, usuario));
//        itens.add(new Movimentacao(produto2, 0, unidade, c1, 0, 0, 0, ModoCadastro.IMPORTACAO, usuario));
//        itens.add(new Movimentacao(produto3, 0, unidade, c1, 0, 0, 0, ModoCadastro.IMPORTACAO, usuario));
//
//        for (int i = 0; i < itens.size(); i++) {
//            dao.save((Movimentacao) itens.get(i));
//        }
//
//        c1.setItens(itens);
//
//        dao.update(c1);
//
//        List<Movimentacao> listaItens;
//
//        System.out.println("listar em ordem ASC ou DESC");
//        listaItens = dao.buscarTudo(Movimentacao.class, Ordem.DESC);
//        for (int i = 0; i < listaItens.size(); i++) {
//            System.out.println(listaItens.get(i).toString());
//        }
//
//        System.out.println("listar em ordem ASC ou DESC por uma ou varias colunas");
//        listaItens = dao.buscarTudo(Movimentacao.class, Ordem.DESC, "id", "data_hora");
//        for (int i = 0; i < listaItens.size(); i++) {
//            System.out.println(listaItens.get(i).toString());
//        }
//
//        dao.closeSession();

        //fim teste
    }

}
