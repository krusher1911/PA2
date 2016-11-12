<div class="modal fade" id="modalCadastrarEntidade" tabindex="-1" role="dialog" aria-labelledby="modalCadastrarEntidadeLabel">
    <div class="modal-dialog" role="document">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <center><h4 class="modal-title">Cadastro de Entidades</h4></center>
            </div>

            <form class="form-horizontal" name="formCadastroEntidade" ng-modal="entidade" novalidate>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputNome">Nome</label>
                        <div class="col-lg-10">
                            <input ng-model="categoria.nome" required class="form-control" id="inputNome" name="nome" placeholder="Nome" type="text" data-toggle="tooltip" data-placement="top" title="Nome da entidade">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputNomeFantasia">Nome Fantasia</label>
                        <div class="col-lg-10">
                            <input ng-model="categoria.nomeFantasia" required class="form-control" id="inputNomeFantasia" name="nomeFantasia" placeholder="Nome Fantasia" type="text" data-toggle="tooltip" data-placement="top" title="Nome fantasia da entidade">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputCpfCnpj">CPF/CNPJ</label>
                        <div class="col-lg-10">
                            <input ng-model="categoria.cnpjCpf" required class="form-control" id="inputCpfCnpj" name="cpfcnpj" placeholder="CPF/CNPJ" type="text" data-toggle="tooltip" data-placement="top" title="CPF/CNPJ da entidade">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputTipo">Tipo</label>
                        <div class="col-lg-10">
                            <input ng-model="categoria.tipo" required class="form-control" id="inputTipo" name="tipo" placeholder="Tipo" type="text" data-toggle="tooltip" data-placement="top" title="Tipo da entidade">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-4 col-lg-offset-7">
                                <button type="submit" id="btnCadastrarCategoria" class="btn btn-primary btn-lg btn-block" data-dismiss="modal" ng-click="cadastrarCategoria(categoria, formCadastroCategoria.$valid)">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!--fim modal cadastrar -->
