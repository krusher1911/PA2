<!-- Conteudo do modal editar -->
<div class="modal fade" id="modalEditarProduto" tabindex="-1" role="dialog" aria-labelledby="modalCadastrarLabel">
    <div class="modal-dialog" role="document">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <center><h4 class="modal-title">Editar Produto</h4></center>
            </div>
            
            <form class="form-horizontal" name="formEdicaoProduto" ng-modal="produto" novalidate="novalidate">
                <div class="modal-body">
                    <div class="form-group" ng-class="
                        {'has-error':!formEdicaoProduto.id.$valid,
                         'has-success':formEdicaoProduto.id.$valid
                            }">
                        <label class="col-lg-2 control-label" for="inputId">C�digo</label>
                        <div class="col-lg-10">
                            <input ng-model="produto.id" required class="form-control" id="inputId" name="id" type="text" data-toggle="tooltip" data-placement="top" title="C�digo" disabled>
                            <p class="help-block" ng-show="formEdicaoProduto.id.$error.required">
                                Informe o id do produto.
                            </p>
                        </div>
                    </div>
                    <div class="form-group" ng-class="
                        {'has-error':!formEdicaoProduto.descricao.$valid,
                         'has-success':formEdicaoProduto.descricao.$valid
                            }">
                        <label class="col-lg-2 control-label" for="inputDescricao">Descri��o</label>
                        <div class="col-lg-10">
                            <input ng-model="produto.descricao" required class="form-control" id="inputDescricao" name="descricao" value="" type="text" data-toggle="tooltip" data-placement="top" title="Descri��o">
                            <p class="help-block" ng-show="formEdicaoProduto.descricao.$error.required">
                                Informe a descri��o do produto.
                            </p>
                        </div>
                    </div>
                    <div class="form-group" ng-class="
                        {'has-error':!formEdicaoProduto.unidade.$valid,
                         'has-success':formEdicaoProduto.unidade.$valid
                            }">
                        <label class="col-lg-2 control-label" for="inputUnidade">Unidade</label>
                        <div class="col-lg-10">
                            <select  class="form-control" ng-model="produto.unidade" required name="unidade" id="selectUnidades"
                                     ng-options="unidade.sigla for unidade in unidades track by unidade.id">
                            </select>
                            <p class="help-block" ng-show="formEdicaoProduto.unidade.$error.required">
                                Selecione a unidade do produto.
                            </p>
                        </div>
                    </div>
                    <div class="form-group" ng-class="
                        {'has-error':!formCadastroProduto.fracionavel.$valid,
                         'has-success':formCadastroProduto.fracionavel.$valid 
                            }">
                        <label class="col-lg-2 control-label" for="inputFracionavel">Fracion�vel</label>
                        <div class="col-lg-6">
                            <label class="radio-inline"><input ng-model="produto.permiteFracionar" ng-value="true" ng-checked="(produto.permiteFracionar == true)" type="radio" id="true">Sim</label>
                            <label class="radio-inline"><input ng-model="produto.permiteFracionar" ng-value="false" ng-checked="(produto.permiteFracionar == false)" type="radio" id="false">N�o</label>
                            <p class="help-block" ng-show="formCadastroProduto.fracionavel.$error.required">
                                Marque se o produto � fracion�vel ou n�o.
                            </p>
                        </div>
                    </div>
                    <div class="form-group" ng-class="
                        {'has-error':!formCadastroProduto.codigoNcm.$valid,
                         'has-success':formCadastroProduto.codigoNcm.$valid
                            }">
                        <label class="col-lg-2 control-label" for="inputCodigoNcm">C�digo NCM</label>
                        <div class="col-lg-10">
                            <input ng-model="produto.codigoNcm" class="form-control" id="inputCodigoNcm" name="codigoNcm" value="${produto.codigoNcm}" type="number" data-toggle="tooltip" data-placement="top" title="C�digo NCM">
                            <p class="help-block" ng-show="formCadastroProduto.codigoNcm.$error.required">
                                Informe o codigo do produto.
                            </p>
                        </div>
                    </div>
                    <div class="form-group" ng-class="
                        {'has-error':!formCadastroProduto.categoria.$valid,
                         'has-success':formCadastroProduto.categoria.$valid
                            }">
                        <label class="col-lg-2 control-label" for="inputCategoria">Categoria</label>
                        <div class="col-lg-10">
                            <select  class="form-control" ng-model="produto.categoria" id="selectUnidades"
                                     ng-options="categoria.nome for categoria in categorias track by categoria.id">
                            </select>
                            <p class="help-block" ng-show="formCadastroProduto.categoria.$error.required">
                                Selecione a categoria do produto.
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-4 col-lg-offset-7">
                                <button type="submit" id="salvar" class="btn btn-primary btn-lg btn-block active" data-dismiss="modal" ng-click="editarProduto(produto, 'PUT', formCadastroProduto.$valid)">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>  
            </form>
        </div>
    </div>
</div>
<!--fim modal-->
