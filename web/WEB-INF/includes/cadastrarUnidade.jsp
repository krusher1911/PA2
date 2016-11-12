<div class="modal fade" id="modalCadastrarUnidade" tabindex="-1" role="dialog" aria-labelledby="modalCadastrarUnidadeLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <center><h4 class="modal-title">Cadastro da Unidade</h4></center>
            </div>

            <form class="form-horizontal" name="formCadastroUnidade" ng-modal="unidade" novalidate>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputDescricao">Descri��o:</label>
                        <div class="col-lg-9">
                            <input ng-model="unidade.descricao" required class="form-control" id="inputDescricao" name="descricao" placeholder="Descri��o" type="text" data-toggle="tooltip" data-placement="top" title="Descri��o da unidade.">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputSigla">Sigla:</label>
                        <div class="col-lg-9">
                            <input ng-model="unidade.sigla" required class="form-control" id="inputSigla" name="sigla" placeholder="L" type="text" data-toggle="tooltip" data-placement="top" title="Sigla da unidade">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-4 col-lg-offset-7">
                                <button type="submit" id="btnCadastrarUnidade" class="btn btn-primary btn-lg btn-block" data-dismiss="modal" ng-click="cadastrarUnidade(unidade, 'POST')">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!--fim modal cadastrar -->
