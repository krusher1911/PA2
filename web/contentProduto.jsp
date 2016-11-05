<%@page import="java.util.List"%>
<%@page import="entity.entitys.Produto"%>
<div class="panel panel-primary">
    <div class="panel panel-heading">
        <div class="row">
                <div class="col-md-4">
                <a id="cadastrarProduto" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalCadastrar"><span class="glyphicon glyphicon-plus"></span></a>
            </div>
            <div class="col-md-4 ">
                    <p class="panel-title" align="center"><strong>Produtos</strong></p>
            </div>
            <div class="col-md-4">

            </div>
        </div>
    </div>
    <div class="panel-body">

        <table id="jsGrid" class="table" action="ajax.">
            <thead class="thead-inverse">
                <tr>
                    <th>Código</th>
                    <th>Descrição</th>
                    <th>Unidade de Medida</th>
                    <th>Fracionavel?</th>
                    <th>Tipo</th>
                    <th>Código NCM</th>
                    <th>Categoria</th>
                    <th>Ações</th>
                </tr>
                <c:forEach var="produto" items="${produtos}">
                    <tr>
                        <td>${produto.id}</td>
                        <td>${produto.getDescricao()}</td>
                        <td>${produto.getUnidade().getDescricao()}</td>
                        <td>${produto.getPermiteFracionar()}</td>
                        <td>${produto.getTipo()}</td>
                        <td>${produto.getCodigNcm()}</td>
                        <td>${produto.getCategoria().getNome()}</td>
                        <td>
                            <button id="editarProduto" type="button" class="editarProduto btn btn-primary btn-sm"><span class="glyphicon glyphicon-edit"></span></button>
                            <button id="removerProduto" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalRemover"><span class="glyphicon glyphicon-remove"></span></button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <jsp:include page="WEB-INF/includes/modalCadastroProduto.jsp"/>
        
        <jsp:include page="WEB-INF/includes/modalEdicaoProduto.jsp"/>

        <jsp:include page="WEB-INF/includes/modalExclusaoProduto.jsp"/>

    </div>
</div>