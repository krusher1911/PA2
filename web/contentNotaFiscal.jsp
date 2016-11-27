<div ng-controller="myController" id="contentNotaFiscal" class="panel panel-primary">
    <div class="panel panel-heading">
        <div class="row">
            <div class="col-md-4">
                <a id="cadastrarNota" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalCadastrarNota" ng-click="abrirCadastrarNotaFiscal()"><span class="glyphicon glyphicon-plus"></span></a>
            </div>
            <div class="col-md-4 ">
                <p class="panel-title" align="center"><strong>Notas Fiscais</strong></p>
            </div>
            <div class="col-md-4">
                
            </div>
        </div>
    </div>
    <!--<div class="panel panel-default">
        <div class="panel-body">
            <label class="col-lg-2 control-label" for="inputDescricao">Buscar nota:</label>
            <div class="col-lg-10">
                <input ng-model="nota.buscarNota" required class="form-control" id="inputNota" name="buscarNota" placeholder="Nota" type="text" data-toggle="tooltip" data-placement="top" title="Digite a chave da nota">
            </div>
        </div>
      </div>-->
    <div class="panel-body">
        <table class="table table-hover">
            <thead class="thead-inverse">
                <tr>
                    <th>Código</th>
                    <th>Chave</th>
                    <!--<th>Emissão</th>-->
                    <th>Entidade</th>
                    <th>Total</th>
                    <th>Número</th>
                    <th>Série</th>
                    <th>Tipo</th>
                    <th>Natureza</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="n in notasFiscais">
                    <td>{{n.id}}</td>
                    <td>{{n.chave}}</td>
                    <!--<td>{{n.emissao}}</td>-->
                    <td>{{n.entidade.nome}}</td>
                    <td>{{n.valorTotal | currency: 'R$'}}</td>
                    <td>{{n.numero}}</td>
                    <td>{{n.serie}}</td>
                    <td>{{n.tipo}}</td>
                    <td>{{n.natureza}}</td>
                    <td>
                        <button id="editarNotaFiscal" type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modalEditarNota" ng-click="abrirEditarNotaFiscal(n.id)"><span class="glyphicon glyphicon-edit"></span></button>
                        <button id="excluirNotaFiscal" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalExcluirNota"><span class="glyphicon glyphicon-remove"></span></button>
                    </td>
                </tr>
            </tbody>
        </table>
        
        <jsp:include page="WEB-INF/includes/cadastrarNotaFiscal.jsp"/>
        
        <jsp:include page="WEB-INF/includes/editarNotaFiscal.jsp"/>
        
        <jsp:include page="WEB-INF/includes/excluirNotaFiscal.jsp"/>
    </div>
</div>