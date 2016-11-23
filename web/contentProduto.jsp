<div ng-controller="myController" id="contentProduto" class="panel panel-primary">
    <div class="panel panel-heading">
        <div class="row">
            <div class="col-md-4">
                <a id="cadastrarProduto" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalCadastrarProduto" ng-click="abrirCadastrarProduto()"><span class="glyphicon glyphicon-plus"></span></a>
            </div>
            <div class="col-md-4 ">
                <p class="panel-title" align="center"><strong>Produtos</strong></p>
            </div>
            <div class="col-md-4">

            </div>
        </div>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead class="thead-inverse">
                <tr>
                    <th>C�digo</th>
                    <th>Descri��o</th>
                    <th>Unidade de Medida</th>
                    <th>Fracionavel?</th>
                    <th>C�digo NCM</th>
                    <th>Categoria</th>
                    <th>Valor M�nimo Estimado</th>
                    <th>Valor M�ximo Estimado</th>
                    <th></th>
                    <th>A��es</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="p in produtos">
                    <td>{{p.id}}</td>
                    <td>{{p.descricao}}</td>
                    <td>{{p.unidade.sigla}}</td>
                    <td ng-if="p.permiteFracionar">Sim</td>
                    <td ng-if="!p.permiteFracionar">N�o</td>
                    <td>{{p.codigoNcm}}</td>
                    <td>{{p.categoria.nome}}</td>
                    <td>{{p.valorMinimo  | currency:'R$'}}</td>
                    <td>{{p.valorMaximo  | currency:'R$'}}</td>
                    <td><a href="{{p.link}}" ng-show="{{p.link}}" target="_blank"> Visualize aqui a busca de pre�o</a></td>
                    <td>
                        <button id="editarProduto"  type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modalEditarProduto" ng-click="abrirEditarProduto(p.id)"><span class="glyphicon glyphicon-edit"></span></button>
                        <button id="removerProduto" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalRemoverProduto" ng-click="confirmacao(p.id)"><span class="glyphicon glyphicon-remove"></span></button>
                        <button id="buscarPreco"  type="button" class="btn btn-success btn-sm" data-toggle="tooltip" data-placement="top" title="Buscar pre�o" ng-click="buscarPreco(p.id)"><span class="glyphicon glyphicon-usd"></span></button>
                    </td>
                </tr>
            </tbody>
        </table>

        <jsp:include page="WEB-INF/includes/modalCadastroProduto.jsp"/>
        
        <jsp:include page="WEB-INF/includes/modalEdicaoProduto.jsp"/>

        <jsp:include page="WEB-INF/includes/modalExclusaoProduto.jsp"/>

        <jsp:include page="WEB-INF/includes/buscaPrecoRealizada.jsp"/>

    </div>
</div>
