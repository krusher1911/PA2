<div class="modal fade" id="modalCadastrarCategoria" tabindex="-1" role="dialog" aria-labelledby="modalCadastrarCategoriaLabel">
    <div class="modal-dialog" role="document">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <center><h4 class="modal-title">Cadastro de Categorias</h4></center>
            </div>

            <form class="form-horizontal" name="formCadastroCategoria" ng-modal="produto" novalidate>
                <div class="modal-body">
                    <div class="form-group" ng-class="
                        {'has-error':!formCadastroCategoria.descricao.$valid,
                         'has-success':formCadastroCategoria.descricao.$valid
                            }">
                        <label class="col-lg-2 control-label" for="inputDescricao">Descrição:</label>
                        <div class="col-lg-10">
                            <input ng-model="categoria.descricao" required class="form-control" id="inputDescricao" name="descricao" placeholder="Descrição" type="text" data-toggle="tooltip" data-placement="top" title="Descrição do produto">
                            <p class="help-block" ng-show="formCadastroCategoria.descricao.$error.required">
                                Informe a descrição do produto.
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-4 col-lg-offset-7">
                                <button type="submit" id="btnCadastrarCategoria" class="btn btn-primary btn-lg btn-block" data-dismiss="modal" ng-click="cadastrarCategoria(categoria, 'POST', formCadastroCategoria.$valid)">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!--fim modal cadastrar -->
