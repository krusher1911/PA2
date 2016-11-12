<div class="modal fade" id="modalCadastrarNota" tabindex="-1" role="dialog" aria-labelledby="modalCadastrarNotaLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <center><h4 class="modal-title">Cadastro de Nota Fiscal</h4></center>
            </div>

            <form class="form-horizontal" name="formCadastroNota" ng-modal="notaFiscal" novalidate>
                <div class="modal-body">
                    <div class="form-group" ng-class="
                        {'has-error':!formCadastroNotaFiscal.chave.$valid,
                         'has-success':formCadastroNotaFiscal.chave.$valid
                            }">
                        <label class="col-lg-3 control-label" for="inputChave">Chave:</label>
                        <div class="col-lg-9">
                            <input ng-model="notaFiscal.chave" required class="form-control" id="inputChave" name="chave" placeholder="234" type="text" data-toggle="tooltip" data-placement="top" title="Chave da nota fiscal">
                            <p class="help-block" ng-show="formCadastroNotaFiscal.chave.$error.required">
                                Digite a chave da nota fiscal.
                            </p>
                        </div>
                    </div>
                    <div class="form-group" ng-class="
                        {'has-error':!formCadastroNotaFiscal.emissao.$valid,
                         'has-success':formCadastroNotaFiscal.emissao.$valid
                            }">
                        <label class="col-lg-3 control-label" for="inputEmissao">Data de emissão:</label>
                        <div class="col-lg-9">
                            <input ng-model="notaFiscal.emissao" required class="form-control" id="inputEmissao" name="emissao" placeholder="01/01/2000" type="text" data-toggle="tooltip" data-placement="top" title="Data de emissão da nota fiscal">
                            <p class="help-block" ng-show="formCadastroNotaFiscal.emissao.$error.required">
                                Digite a data de emissão da nota fiscal.
                            </p>
                        </div>
                    </div>
                    <div class="form-group" ng-class="
                        {'has-error':!formCadastroNotaFiscal.entidade.$valid,
                         'has-success':formCadastroNotaFiscal.entidade.$valid
                            }">
                        <label class="col-lg-2 control-label" for="inputEntidade">Entidade</label>
                        <div class="col-lg-10">
                            <select  class="form-control" ng-model="notaFiscal.entidade" name="entidade" required id="selectEntidades"
                                     ng-options="entidade.logadouro for entidade in entidades track by entidade.id">
                            </select>
                            <p class="help-block" ng-show="formCadastroNotaFiscal.entidade.$error.required">
                                Selecione a entidade relacionada a nota fiscal.
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputValorTotal">Valor Total:</label>
                        <div class="col-lg-9">
                            <div <div class="input-group">
                                <span class="input-group-addon">R$</span>
                                <input ng-model="notaFiscal.valorTotal" required class="form-control" id="inputValorTotal" name="valorTotal" placeholder="0,00" type="text" data-toggle="tooltip" data-placement="top" title="Chave da nota fiscal">
                            </div>
                        </div>
                    </div>
                        <div class="form-group" ng-class="
                        {'has-error':!formCadastroNotaFiscal.numero.$valid,
                         'has-success':formCadastroNotaFiscal.numero.$valid
                            }">
                            <label class="col-lg-3 control-label" for="inputNumero">Número:</label>
                        <div class="col-lg-9">
                            <input ng-model="notaFiscal.numero" required class="form-control" id="inputNumero" name="numero" placeholder="3214568" type="text" data-toggle="tooltip" data-placement="top" title="Número da nota fiscal">
                            <p class="help-block" ng-show="formCadastroNotaFiscal.numero.$error.required">
                                Informe o número da nota fiscal.
                            </p>
                        </div>
                    </div>
                        <div class="form-group" ng-class="
                        {'has-error':!formCadastroNotaFiscal.serie.$valid,
                         'has-success':formCadastroNotaFiscal.serie.$valid
                            }">
                            <label class="col-lg-3 control-label" for="inputSerie">Série:</label>
                        <div class="col-lg-9">
                            <input ng-model="notaFiscal.serie" required class="form-control" id="inputSerie" name="serie" placeholder="5675" type="text" data-toggle="tooltip" data-placement="top" title="Serie da nota fiscal.">
                            <p class="help-block" ng-show="formCadastroNotaFiscal.serie.$error.required">
                                Informe a serie.
                            </p>
                        </div>
                    </div>
                        <div class="form-group" ng-class="
                        {'has-error':!formCadastroNotaFiscal.tipo.$valid,
                         'has-success':formCadastroNotaFiscal.tipo.$valid
                            }">
                            <label class="col-lg-2 control-label" for="inputTipo">Tipo</label>
                            <div class="col-lg-10">
                                <select class="form-control" ng-model="notaFiscal.tipo" name="tipo" required id="selectTipo">
                                    <option value="FÍSICA"> PESSOA FÍSICA </option>
                                    <option value="JURIDICA"> PESSOA JURIDICA </option>
                                </select>
                                <p class="help-block" ng-show="formCadastroNotaFiscal.tipo.$error.required">
                                    Selecione o tipo da entidade relacionada na nota fiscal.
                                </p>
                            </div>
                            <!--<input ng-model="notaFiscal.tipo" required class="form-control" id="inputTipo" name="tipo" placeholder="12345" type="text" data-toggle="tooltip" data-placement="top" title="Tipo da nota fiscal.">-->
                        </div>
                        <div class="form-group" ng-class="
                        {'has-error':!formCadastroNotaFiscal.natureza.$valid,
                         'has-success':formCadastroNotaFiscal.natureza.$valid
                            }">
                            <label class="col-lg-2 control-label" for="inputNatureza">Natureza</label>
                            <div class="col-lg-10">
                                <select class="form-control" ng-model="notaFiscal.natureza" name="natureza" required id="selectNatureza">
                                    <option value="BONIFICAÇÃO"> BONIFICAÇÃO </option>
                                    <option value="DEVOLUÇÃO"> DEVOLUÇÃO </option>
                                    <option value="VENDA"> VENDA </option>
                                </select>
                                <p class="help-block" ng-show="formCadastroNotaFiscal.natureza.$error.required">
                                    Selecione a natureza da nota fiscal.
                                </p>
                            </div>
                        </div>
                        <div class="form-group">
                        <div class="row">
                            <div class="col-lg-4 col-lg-offset-7">
                                <button type="submit" id="btnCadastrarProduto" class="btn btn-primary btn-lg btn-block" data-dismiss="modal" ng-click="cadastrarNotaFiscal(notaFiscal)">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!--fim modal cadastrar -->
