<!-- Conteudo do modal cadastrar -->
<div class="modal fade" id="modalCadastrarMovimentacao" tabindex="-1" role="dialog" aria-labelledby="modalCadastrarMovimentacaoLabel">
    <div class="modal-dialog" role="document">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <center><h4 class="modal-title">Cadastro de Movimentação</h4></center>
            </div>

            <form class="form-horizontal">
                <div class="modal-body">
                </div><div class="form-group">
                    <label class="col-lg-2 control-label" for="inputNotaFiscal">Nota Fiscal:</label>
                    <div class="col-lg-10">
                        <input ng-model="movimentacao.notaFiscal" class="form-control" id="inputNotaFiscal" name="notaFiscal" placeholder="Nota Fiscal" type="text" data-toggle="tooltip" data-placement="top" title="Nota Fiscal referente a movimentação">
                    </div>
                </div>
                <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputProduto">Produto</label>
                        <div class="col-lg-10">
                            <select  class="form-control" ng-model="movimentacao.produto" id="selectNotasFiscais"
                                     ng-options="produto.descricao for produto in produtos track by produto.id">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputUnidade">Unidade</label>
                        <div class="col-lg-10">
                            <select  class="form-control" ng-model="movimentacao.unidade" id="selectUnidades"
                                     ng-options="unidade.sigla for unidade in unidades track by unidade.id">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputQuantidade">Quantidade</label>
                        <div class="col-lg-10">
                            <input ng-model="movimentacao.quantidade"  class="form-control" id="inputTipo" name="quantidade" placeholder="Quantidade" type="text" data-toggle="tooltip" data-placement="top" title="Quantidade">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputValorUnitario">Valor Unitário</label>
                        <div class="col-lg-10">
                            <input ng-model="movimentacao.unitario" class="form-control" id="inputValorUnitario" name="unitario" placeholder="Valor Unitário" type="text" data-toggle="tooltip" data-placement="top" title="Valor Unitário">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputValorDesconto">Valor Desconto</label>
                        <div class="col-lg-10">
                            <input ng-model="movimentacao.desconto" class="form-control" id="inputValorDesconto" name="desconto" placeholder="Valor Desconto" type="text" data-toggle="tooltip" data-placement="top" title="Valor Desconto">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputValorTotal">Valor Total</label>
                        <div class="col-lg-10">
                            <!--calcular de acordo com a quantidade, valor unitario e desconto-->
                            <input ng-model="movimentacao.total" class="form-control" id="inputValorTotal" name="total" placeholder="Valor Total" type="text" data-toggle="tooltip" data-placement="top" title="Valor Total" disabled>
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
