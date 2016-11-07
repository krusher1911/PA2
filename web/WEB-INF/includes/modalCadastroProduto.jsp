<!-- Conteudo do modal cadastrar -->
<div class="modal fade" id="modalCadastrarProduto" tabindex="-1" role="dialog" aria-labelledby="modalCadastrarLabel">
    <div class="modal-dialog" role="document">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <center><h4 class="modal-title">Cadastro de Produtos</h4></center>
            </div>

            <form class="form-horizontal" name="formCadastroProduto" ng-modal="produto" novalidate>
                <div class="modal-body">
                    <div class="form-group" ng-class="
                        {'has-error':!formCadastroProduto.descricao.$valid,
                         'has-success':formCadastroProduto.descricao.$valid
                            }">
                        <label class="col-lg-2 control-label" for="inputDescricao">Descrição:</label>
                        <div class="col-lg-10">
                            <input ng-model="produto.descricao" required class="form-control" id="inputDescricao" name="descricao" placeholder="Descrição" type="text" data-toggle="tooltip" data-placement="top" title="Descrição do produto">
                            <p class="help-block" ng-show="formCadastroProduto.descricao.$error.required">
                                Informe a descrição do produto.
                            </p>
                        </div>
                    </div>
                    <div class="form-group" ng-class="
                        {'has-error':!formCadastroProduto.unidade.$valid,
                         'has-success':formCadastroProduto.unidade.$valid
                            }">
                        <label class="col-lg-2 control-label" for="inputUnidade">Unidade</label>
                        <div class="col-lg-10">
                            <select  class="form-control" ng-model="produto.unidade" name="unidade" required id="selectUnidades"
                                     ng-options="unidade.sigla for unidade in unidades track by unidade.id">
                            </select>
                            <p class="help-block" ng-show="formCadastroProduto.unidade.$error.required">
                                Selecione a unidade do produto.
                            </p>
                        </div>
                    </div>
                    <div class="form-group" ng-class="
                        {'has-error':!formCadastroProduto.fracionavel.$valid,
                         'has-success':formCadastroProduto.fracionavel.$valid 
                            }">
                        <label class="col-lg-2 control-label" for="inputFracionavel">Fracionável</label>
                        <div class="col-lg-6">
                            <label class="radio-inline"><input ng-model="produto.permiteFracionar" required ng-value="true" ng-checked="(produto.permiteFracionar == true)" type="radio" name="fracionavel">Sim</label>
                            <label class="radio-inline"><input ng-model="produto.permiteFracionar" required ng-value="false" ng-checked="(produto.permiteFracionar == false)"type="radio" name="fracionavel">Não</label>
                            <p class="help-block" ng-show="formCadastroProduto.fracionavel.$error.required">
                                Marque se o produto é fracionável ou não.
                            </p>
                        </div>
                    </div>
                    <div class="form-group" ng-class="
                        {'has-error':!formCadastroProduto.tipo.$valid,
                         'has-success':formCadastroProduto.tipo.$valid 
                            }">
                        <label class="col-lg-2 control-label" for="inputTipo">Tipo</label>
                        <div class="col-lg-10">
                            <input ng-model="produto.tipo" required ng-maxlength="1" class="form-control" id="inputTipo" name="tipo" placeholder="A" type="text" data-toggle="tooltip" data-placement="top" title="Por favor, insira apenas uma letra.">
                            <p class="help-block" ng-show="formCadastroProduto.tipo.$error.required">
                                Informe o tipo do produto.
                            </p>
                        </div>
                    </div>
                    <div class="form-group" ng-class="
                        {'has-error':!formCadastroProduto.codigoNcm.$valid,
                         'has-success':formCadastroProduto.codigoNcm.$valid
                            }">
                        <label class="col-lg-2 control-label" for="inputCodigoNcm">Código NCM</label>
                        <div class="col-lg-10">
                            <input ng-model="produto.codigoNcm" required class="form-control" id="inputCodigoNcm" name="codigoNcm" placeholder="12345" type="number" data-toggle="tooltip" data-placement="top" title="For favor, insira um número.">
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
                            <select  class="form-control" ng-model="produto.categoria" name="categoria" required id="selectUnidades"
                                     ng-options="categoria.nome for categoria in categorias track by categoria.id">
                            </select>
                            <p class="help-block" ng-show="formCadastroProduto.categoria.$error.required">
                                Selecione a categoria do produto.
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-4 col-lg-offset-7">
                                <button type="submit" id="btnCadastrarProduto" class="btn btn-primary btn-lg btn-block" data-dismiss="modal" ng-click="cadastrarProduto(produto, 'POST', formCadastroProduto.$valid)">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>
<!--fim modal cadastrar -->
