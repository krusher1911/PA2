<div ng-controller="myController" id="contentMovimentacao" class="panel panel-primary">
    <div class="panel panel-heading">
        <div class="row">
            <div class="col-md-4">
                <a id="cadastrarMovimentacao" ng-click="abrirCadastrarMovimentacao()" type="button" class="btn btn-primary" data-toggle="modal"><span class="glyphicon glyphicon-plus"></span></a>
            </div>
            <div class="col-md-4 ">
                <p class="panel-title" align="center"><strong>Movimentações</strong></p>
            </div>
            <div class="col-md-4">

            </div>
        </div>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead class="thead-inverse">
                <tr>
                    <th>Nota Fiscal</th>
                    <th>Item</th>
                    <th>Descrição</th>
                    <th>Unidade de Medida</th>
                    <th>Quantidade</th>
                    <th>Valor Unitário</th>
                    <th>Valor Desconto</th>
                    <th>Valor Total</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="m in movimentacoes">
                    <td>{{m.notaFiscal.chave}}</td>
                    <td>{{m.id}}</td>
                    <td>{{m.produto.descricao}}</td>
                    <td>{{m.unidade.sigla}}</td>
                    <td>{{m.quantidade}}</td>
                    <td>{{m.unitario}}</td>
                    <td>{{m.desconto}}</td>
                    <td>{{m.total}}</td>
                    <td>
                        <button id="editarProduto" type="button" class="btn btn-primary btn-sm" data-toggle="modal"><span class="glyphicon glyphicon-edit"></span></button>
                        <button id="removerProduto" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalRemoverMovimentacao"><span class="glyphicon glyphicon-remove"></span></button>
                    </td>
                </tr>
            </tbody>
        </table>

        <jsp:include page="WEB-INF/includes/cadastrarMovimentacao.jsp"/>

        <jsp:include page="WEB-INF/includes/editarMovimentacao.jsp"/>

        <jsp:include page="WEB-INF/includes/excluirMovimentacao.jsp"/>

    </div>
</div>