<div class="modal fade" id="modalEditarCategoria" tabindex="-1" role="dialog" aria-labelledby="modalEditarCategoriaLabel">
    <div class="modal-dialog" role="document">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <center><h4 class="modal-title">Editar Categoria</h4></center>
            </div>

            <form class="form-horizontal" name="formEditarCategoria" ng-modal="categoria" novalidate>
                <div class="modal-body">
                    <div class="form-group" ng-class="
                        {'has-error':!formEditarCategoria.id.$valid,
                         'has-success':formEditarCategoria.id.$valid
                            }">
                        <label class="col-lg-2 control-label" for="inputId">Código</label>
                        <div class="col-lg-10">
                            <input ng-model="categoria.id" required class="form-control" id="inputId" name="coidigo" placeholder="Código" type="text" data-toggle="tooltip" data-placement="top" title="Código da categoria" disabled>
                        </div>
                    </div>
                    <div class="form-group" ng-class="
                        {'has-error':!formEditarCategoria.nome.$valid,
                         'has-success':formEditarCategoria.nome.$valid
                            }">
                        <label class="col-lg-2 control-label" for="inputNome">Nome</label>
                        <div class="col-lg-10">
                            <input ng-model="categoria.nome" required class="form-control" id="inputNome" name="nome" placeholder="Nome" type="text" data-toggle="tooltip" data-placement="top" title="Nome da categoria">
                            <p class="help-block" ng-show="formEditarCategoria.nome.$error.required">
                                Informe o nome da categoria.
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-4 col-lg-offset-7">
                                <button type="submit" id="btnEditarCategoria" class="btn btn-primary btn-lg btn-block" data-dismiss="modal" ng-click="editarCategoria(categoria, formEditarCategoria.$valid)">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!--fim modal editar -->
