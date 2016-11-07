<div ng-controller="myController" id="contentCategoria" class="panel panel-primary">
    <div class="panel panel-heading">
        <div class="row">
            <div class="col-md-4">
                <a id="cadastrarCategoria" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalCadastrarCategoria" ng-click="abrirCadastrarCategoria()"><span class="glyphicon glyphicon-plus"></span></a>
            </div>
            <div class="col-md-4 ">
                <p class="panel-title" align="center"><strong>Categorias</strong></p>
            </div>
            <div class="col-md-4">

            </div>
        </div>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead class="thead-inverse">
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="c in categorias">
                    <td>{{c.id}}</td>
                    <td>{{c.nome}}</td>
                    <td>
                        <button id="editarCategoria"  type="button" class="editarProduto btn btn-primary btn-sm" data-toggle="modal" data-target="#modalEditarCategoria" ng-click="abrirEditarCategoria(c.id)"><span class="glyphicon glyphicon-edit"></span></button>
                        <button id="removerCategoria" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalRemoverCategoria" ng-click="confirmacao(c.id)"><span class="glyphicon glyphicon-remove"></span></button>
                    </td>
                </tr>
            </tbody>
        </table>
        
        <jsp:include page="WEB-INF/includes/CadastrarCategoria.jsp"/>
        
        <jsp:include page="WEB-INF/includes/EditarCategoria.jsp"/>

        <%--<jsp:include page="WEB-INF/includes/ExcluirCategoria.jsp"/>--%>
    </div>
</div>
