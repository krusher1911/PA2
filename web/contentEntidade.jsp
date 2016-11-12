<div ng-controller="myController" id="contentEntidade" class="panel panel-primary">
    <div class="panel panel-heading">
        <div class="row">
            <div class="col-md-4">
                <a id="cadastrarEntidade" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalCadastrarEntidade" ng-click="abrirCadastrarEntidade()"><span class="glyphicon glyphicon-plus"></span></a>
            </div>
            <div class="col-md-4 ">
                <p class="panel-title" align="center"><strong>Entidades</strong></p>
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
                    <th>Tipo</th>
                    <th>Nome</th>
                    <th>Nome Fantasia</th>
                    <th>CPF/CNPJ</th>
                    <th>Endereco</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="e in entidades">
                    <td>{{e.id}}</td>
                    <td>{{e.tipoEntidade}}</td>
                    <td>{{e.nome}}</td>
                    <td>{{e.nomeFantasia}}</td>
                    <td>{{e.cnpjCpf}}</td>
                    <td>{{e.endereco}}</td>
                    <td>
                        <button id="editarEntidade"  type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modalEditarEntidade" ng-click="abrirEditarEntidade(e.id)"><span class="glyphicon glyphicon-edit"></span></button>
                        <button id="excluirEntidade" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalRemoverEntidade" ng-click="confirmacao(e.id)"><span class="glyphicon glyphicon-remove"></span></button>
                    </td>
                </tr>
            </tbody>
        </table>
        
        <jsp:include page="WEB-INF/includes/cadastrarEntidade.jsp"/>
        
    </div>
</div>
