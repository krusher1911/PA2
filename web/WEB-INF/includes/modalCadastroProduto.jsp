<!-- Conteudo do modal cadastrar -->
<div class="modal fade" id="modalCadastrar" tabindex="-1" role="dialog" aria-labelledby="modalCadastrarLabel">
    <div class="modal-dialog" role="document">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <center><h4 class="modal-title">Cadastro de Produtos</h4></center>
            </div>

            <form class="form-horizontal" ng-modal="produto">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputDescricao">Descrição:</label>
                        <div class="col-lg-10">
                            <input ng-model="produto.descricao" class="form-control" id="inputDescricao" name="descricao" placeholder="Descrição" type="text" data-toggle="tooltip" data-placement="top" title="Descrição do produto">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputUnidade">Unidade</label>
                        <div class="col-lg-10">
                            <select  class="form-control" ng-model="produto.unidade" id="selectUnidades"
                                     ng-options="unidade.sigla for unidade in unidades track by unidade.id">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputFracionavel">Fracionável</label>
                        <div class="col-lg-6">
                            <label class="radio-inline"><input ng-model="produto.permiteFracionar" ng-value="true" ng-checked="(produto.permiteFracionar == true)" type="radio" name="fracionavel">Sim</label>
                            <label class="radio-inline"><input ng-model="produto.permiteFracionar" ng-value="false" ng-checked="(produto.permiteFracionar == false)"type="radio" name="fracionavel">Não</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputTipo">Tipo</label>
                        <div class="col-lg-10">
                            <input ng-model="produto.tipo"  class="form-control" id="inputTipo" name="tipo" placeholder="Tipo" type="text" data-toggle="tooltip" data-placement="top" title="Tipo">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputCodigoNcm">Código NCM</label>
                        <div class="col-lg-10">
                            <input ng-model="produto.codigoNcm" class="form-control" id="inputCodigoNcm" name="codigoNcm" placeholder="Código NCM" type="text" data-toggle="tooltip" data-placement="top" title="Código NCM">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputCategoria">Categoria</label>
                        <div class="col-lg-10">
                            <select  class="form-control" ng-model="produto.categoria" id="selectUnidades"
                                     ng-options="categoria.nome for categoria in categorias track by categoria.id">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-4 col-lg-offset-7">
                                <button type="submit" class="btn btn-primary btn-lg btn-block active" ng-click="cadastrarProduto(produto, 'POST')" data-dismiss="modal">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>
<!--fim modal cadastrar -->
