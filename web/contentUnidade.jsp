<div ng-controller="myController" id="contentUnidade" class="panel panel-primary">
    <div class="panel panel-heading">
        <div class="row">
            <div class="col-md-4">
                <a id="cadastrarUnidade" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalCadastrarUnidade" ng-click="abrirCadastrarUnidade()"><span class="glyphicon glyphicon-plus"></span></a>
            </div>
            <div class="col-md-4 ">
                <p class="panel-title" align="center"><strong>Unidades</strong></p>
            </div>
            <div class="col-md-4">
                
            </div>
        </div>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead class="thead-inverse">
                <tr>
                    <th>Código</th>
                    <th>Descrição</th>
                    <th>Sigla</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="u in unidades">
                    <td>{{u.id}}</td>
                    <td>{{u.descricao}}</td>
                    <td>{{u.sigla}}</td>
                    <td>
                        <button id="editarUnidade"  type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modalEditarUnidade" ng-click="abrirEditarUnidade(u.id)"><span class="glyphicon glyphicon-edit"></span></button>
                        <button id="excluirUnidade" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalRemoverUnidade" ng-click="confirmacao(u.id)"><span class="glyphicon glyphicon-remove"></span></button>
                    </td>
                </tr>
            </tbody>
        </table>
        
        <jsp:include page="WEB-INF/includes/cadastrarUnidade.jsp"/>
        
        <jsp:include page="WEB-INF/includes/editarUnidade.jsp"/>

        <jsp:include page="WEB-INF/includes/excluirUnidade.jsp"/>
        
    </div>
</div>
