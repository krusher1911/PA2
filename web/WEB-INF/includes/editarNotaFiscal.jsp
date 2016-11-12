<div class="modal fade" id="modalEditarNota" tabindex="-1" role="dialog" aria-labelledby="modalEditarNotaLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <center><h4 class="modal-title">Edição de Nota Fiscal</h4></center>
            </div>

            <form class="form-horizontal" name="formCadastroNota" ng-modal="notaFiscal" novalidate>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputEmissao">Código da nota:</label>
                        <div class="col-lg-9">
                            <input ng-model="notaFiscal.chave" required disabled class="form-control" id="inputEmissao" name="emissao" placeholder="234" type="text" data-toggle="tooltip" data-placement="top" title="Código da nota fiscal">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputEmissao">Data de emissão:</label>
                        <div class="col-lg-9">
                            <input ng-model="notaFiscal.emissao" required class="form-control" id="inputEmissao" name="emissao" placeholder="01/01/2000" type="text" data-toggle="tooltip" data-placement="top" title="Data de emissão da nota fiscal">
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
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputNumero">Número:</label>
                        <div class="col-lg-9">
                            <input ng-model="notaFiscal.numero" required class="form-control" id="inputNumero" name="numero" placeholder="3214568" type="text" data-toggle="tooltip" data-placement="top" title="Número da nota fiscal">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputSerie">Série:</label>
                        <div class="col-lg-9">
                            <input ng-model="notaFiscal.serie" required class="form-control" id="inputSerie" name="serie" placeholder="5675" type="text" data-toggle="tooltip" data-placement="top" title="Serie da nota fiscal.">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputTipo">Tipo:</label>
                        <div class="col-lg-9">
                            <input ng-model="notaFiscal.tipo" required class="form-control" id="inputTipo" name="tipo" placeholder="12345" type="text" data-toggle="tooltip" data-placement="top" title="Tipo da nota fiscal.">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputNatureza">Natureza:</label>
                        <div class="col-lg-9">
                            <input ng-model="notaFiscal.natureza" required class="form-control" id="inputNatureza" name="natureza" placeholder="E" type="text" data-toggle="tooltip" data-placement="top" title="Natureza da nota fiscal.">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-4 col-lg-offset-7">
                                <button type="submit" id="btnCadastrarProduto" class="btn btn-primary btn-lg btn-block" data-dismiss="modal" ng-click="editarNotaFiscal(notaFiscal, 'PUT')">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!--fim modal cadastrar -->
