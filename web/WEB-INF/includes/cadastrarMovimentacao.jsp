<!-- Conteudo do modal cadastrar -->
<div class="modal fade" id="modalCadastrarMovimentacao" tabindex="-1" role="dialog" aria-labelledby="modalCadastrarMovimentacaoLabel">
    <div class="modal-dialog" role="document">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <center><h4 class="modal-title">Cadastro de Movimentação</h4></center>
            </div>

            <form class="form-horizontal" name="formCadastroMovimentacao" ng-modal="movimentacao" novalidate>
                <div class="modal-body">
                    <div class="form-group" ng-class="
                        {'has-error':!formCadastroMovimentacao.notaFiscal.$valid,
                         'has-success':formCadastroMovimentacao.notaFiscal.$valid
                            }">
                        <label class="col-lg-3 control-label" for="inputNotaFiscal">Nota Fiscal:</label>
                        <div class="col-lg-9">
                            <input ng-model="movimentacao.notaFiscal" class="form-control" id="inputNotaFiscal" name="notaFiscal" placeholder="Nota Fiscal" type="text" data-toggle="tooltip" data-placement="top" title="Nota Fiscal referente a movimentação">
                            <p class="help-block" ng-show="formCadastroMovimentacao.notaFiscal.$error.required">
                                Informe o código da nota fiscal.
                            </p>
                            <pre>{{formCadastroMovimentacao.notaFiscal.$error.required}}</pre>
                        </div>
                    </div>
                <div class="form-group" ng-class="
                        {'has-error':!formCadastroMovimentacao.produto.$valid,
                         'has-success':formCadastroMovimentacao.produto.$valid
                            }">
                        <label class="col-lg-3 control-label" for="inputProduto">Produto</label>
                        <div class="col-lg-9">
                            <select  class="form-control" name="produto" ng-model="movimentacao.produto" id="selectProduto"
                                     ng-options="produto.descricao for produto in produtos track by produto.id">
                            </select>
                            <p class="help-block" ng-show="formCadastroMovimentacao.produto.$error.required">
                                Selecione o produto da movimentação.
                            </p>
                            <pre>{{formCadastroMovimentacao.$valid}}</pre>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputUnidade">Unidade</label>
                        <div class="col-lg-9">
                            <select  class="form-control" ng-model="movimentacao.unidade" id="selectUnidades"
                                     ng-options="unidade.sigla for unidade in unidades track by unidade.id">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputQuantidade">Quantidade</label>
                        <div class="col-lg-9">
                            <input ng-model="movimentacao.quantidade" ng-change="cacTotal()" class="form-control" id="inputTipo" name="quantidade" placeholder="Quantidade" type="number" data-toggle="tooltip" data-placement="top" title="Quantidade">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputValorUnitario">Valor Unitário</label>
                        <div class="col-lg-9">
                            <div <div class="input-group">
                                <span class="input-group-addon">R$</span>
                                <input ng-model="movimentacao.unitario" ng-change="cacTotal()" class="form-control" id="inputValorUnitario" name="unitario" placeholder="Valor Unitário" type="text" data-toggle="tooltip" data-placement="top" title="Valor Unitário">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputValorDesconto">Valor Desconto</label>
                        <div class="col-lg-9">
                            <div <div class="input-group">
                                <span class="input-group-addon">R$</span>
                                <input ng-model="movimentacao.desconto" ng-change="cacTotal()" class="form-control" id="inputValorDesconto" name="desconto" placeholder="Valor Desconto" type="text" data-toggle="tooltip" data-placement="top" title="Valor Desconto">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputValorTotal">Valor Total</label>
                        <div class="col-lg-9">
                            <div <div class="input-group">
                                <span class="input-group-addon">R$</span>
                                <input ng-model="movimentacao.total" ng-bind="" disabled class="form-control" id="inputValorTotal" name="total" placeholder="Valor Total" type="text" data-toggle="tooltip" data-placement="top" title="Valor Total">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-4 col-lg-offset-7">
                                <button type="submit" class="btn btn-primary btn-lg btn-block active" ng-click="cadastrarMovimentacao(movimentacao)" data-dismiss="modal">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!--fim modal cadastrar -->
