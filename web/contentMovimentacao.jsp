<div class="panel panel-primary">
    <div class="panel panel-heading">
        <div class="row">
            <div class="col-md-4">
                <a id="cadastrarMovimentacao" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalCadastrarMovimentacao"><span class="glyphicon glyphicon-plus"></span></a>
            </div>
            <div class="col-md-4 ">
                <p class="panel-title" align="center"><strong>Movimentações</strong></p>
            </div>
            <div class="col-md-4">

            </div>
        </div>
    </div>
    <div class="panel-body">
        <table id="jsGrid" class="table table-hover" action="ajax.">
            <thead class="thead-inverse">
                <tr>
                    <th>Data</th>
                    <th>ID Nota</th>
                    <th>Descrição</th>
                    <th>Quantidade</th>
                    <th>Valor Desconto</th>
                    <th>Valor Unitário</th>
                    <th>Valor Total</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="movimentacao" items="${movimentacoes}">
                <tr>
                    <td>${movimentacao.getId()}</td>
                    <td>${movimentacao.getDescricao()}</td>
                    <td>${movimentacao.getUnidade().getDescricao()}</td>
                    <td>${movimentacao.getPermiteFracionar()}</td>
                    <td>${movimentacao.getTipo()}</td>
                    <td>${movimentacao.getCodigNcm()}</td>
                    <td>${movimentacao.getCategoria().getNome()}</td>
                    <td>
                        <button id="editarProduto" type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modalEditar"><span class="glyphicon glyphicon-edit"></span></button>
                        <button id="removerProduto" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalRemover"><span class="glyphicon glyphicon-remove"></span></button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>