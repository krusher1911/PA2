<div class="modal fade" id="modalEditarCategoria" tabindex="-1" role="dialog" aria-labelledby="modalEditarCategoriaLabel">
    <div class="modal-dialog" role="document">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <center><h4 class="modal-title">Edição de Categorias</h4></center>
            </div>

            <form class="form-horizontal" name="formEdicaoCategoria" ng-modal="produto" novalidate>
                <div class="modal-body">
                    <div class="form-group" ng-class="
                        {'has-error':!formEdicaoCategoria.id.$valid,
                         'has-success':formEdicaoCategoria.id.$valid
                            }">
                        <label class="col-lg-2 control-label" for="inputID">ID:</label>
                        <div class="col-lg-10">
                            <input ng-model="categoria.id" required class="form-control" id="inputID" name="id" placeholder="ID" type="text" data-toggle="tooltip" data-placement="top" title="ID do produto">
                            <p class="help-block" ng-show="formEdicaoCategoria.id.$error.required">
                                Informe o id da categoria.
                            </p>
                        </div>
                    </div>
                    <div class="form-group" ng-class="
                        {'has-error':!formEdicaoCategoria.descricao.$valid,
                         'has-success':formEdicaoCategoria.descricao.$valid
                            }">
                        <label class="col-lg-2 control-label" for="inputDescricao">Descrição:</label>
                        <div class="col-lg-10">
                            <input ng-model="categoria.descricao" required class="form-control" id="inputDescricao" name="descricao" placeholder="Descrição" type="text" data-toggle="tooltip" data-placement="top" title="Descrição do produto">
                            <p class="help-block" ng-show="formEdicaoCategoria.descricao.$error.required">
                                Informe a descrição da categoria.
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-4 col-lg-offset-7">
                                <button type="submit" id="btnEditarCategoria" class="btn btn-primary btn-lg btn-block" data-dismiss="modal" ng-click="editarCategoria(categoria, 'POST', formEdicaoCategoria.$valid)">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
