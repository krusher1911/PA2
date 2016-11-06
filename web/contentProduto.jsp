<div ng-controller="myController" id="contentProduto" class="panel panel-primary">
    <div class="panel panel-heading">
        <div class="row">
                <div class="col-md-4">
                    <a id="cadastrarProduto" type="button" class="btn btn-primary" ng-click="abrirCadastrarProduto()"><span class="glyphicon glyphicon-plus"></span></a>
                </div>
            <div class="col-md-4 ">
                    <p class="panel-title" align="center"><strong>Produtos</strong></p>
            </div>
            <div class="col-md-4">

            </div>
        </div>
    </div>
    <div class="panel-body">

        <table id="jsGrid" class="table table-hover">
            <thead class="thead-inverse">
                <tr>
                    <th>C�digo</th>
                    <th>Descri��o</th>
                    <th>Unidade de Medida</th>
                    <th>Fracionavel?</th>
                    <th>Tipo</th>
                    <th>C�digo NCM</th>
                    <th>Categoria</th>
                    <th>A��es</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="p in produtos">
                    <td>{{p.id}}</td>
                    <td>{{p.descricao}}</td>
                    <td>{{p.unidade.sigla}}</td>
                    <td>{{p.permiteFracionar}}</td>
                    <td>{{p.tipo}}</td>
                    <td>{{p.codigNcm}}</td>
                    <td>{{p.categoria.nome}}</td>
                    <td>
                        <button id="editarProduto" ng-click="abrirEditarProduto(p.id)" type="button" class="editarProduto btn btn-primary btn-sm"><span class="glyphicon glyphicon-edit"></span></button>
                        <button id="removerProduto" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalRemover" ng-click="confirmDel(p.id)"><span class="glyphicon glyphicon-remove"></span></button>
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