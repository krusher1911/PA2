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
                        <label class="col-lg-3 control-label" for="inputNome">Nome</label>
                        <div class="col-lg-9">
                            <input ng-model="categoria.nome" required class="form-control" id="inputNome" name="nome" placeholder="Nome" type="text" data-toggle="tooltip" data-placement="top" title="Nome da entidade">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputNomeFantasia">Nome Fantasia</label>
                        <div class="col-lg-9">
                            <input ng-model="categoria.nomeFantasia" required class="form-control" id="inputNomeFantasia" name="nomeFantasia" placeholder="Nome Fantasia" type="text" data-toggle="tooltip" data-placement="top" title="Nome fantasia da entidade">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="inputCpfCnpj">CPF/CNPJ</label>
                        <div class="col-lg-9">
                            <input ng-model="categoria.cnpjCpf" required class="form-control" id="inputCpfCnpj" name="cpfcnpj" placeholder="CPF/CNPJ" type="text" data-toggle="tooltip" data-placement="top" title="CPF/CNPJ da entidade">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3" for="inputAddress">Endereço</label>
                        <div class="col-lg-9">
                            <div class="input-group">
                                <input name="fullAddress" ng-model="fullAddress" type="text" class="form-control" disabled id="inputAddress" placeholder="555, 15th street. New York - NY">
                                <span class="input-group-btn">
                                    <button id="btnCadEnd" class="btn btn-secondary btn-primary" type="button" ng-click="abrirCadastrarEndereco()">{{textBtnCadEnd}}</button>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div id="contantAdress" class="hidden">
                        <div class="form-group">
                            <label class="control-label col-lg-3" for="inputTipoLogradouro">Tipo Logradouro</label>
                            <div class="col-lg-9">
                                <label class="radio-inline col-lg-3"><input ng-model="endereco.tipo_logradouro" required ng-value="ALAMEDA" ng-checked="(produto.tipo_logradouro == false)" type="radio" name="tipoLogradouro">Alameda</label>
                                <label class="radio-inline col-lg-3"><input ng-model="endereco.tipo_logradouro" required ng-value="AVENIDADE" ng-checked="(produto.tipo_logradouro == false)"type="radio" name="tipoLogradouro">Avenida</label>
                                <label class="radio-inline col-lg-3"><input ng-model="endereco.tipo_logradouro" required ng-value="ESTRADA" ng-checked="(produto.tipo_logradouro == false)"type="radio" name="tipoLogradouro">Estrada</label>
                            </div>
                            <div class="col-lg-3">
                            </div>
                            <div class="col-lg-9">
                                <label class="radio-inline col-lg-3"><input ng-model="endereco.tipo_logradouro" required ng-value="RODOVIA" ng-checked="(produto.tipo_logradouro == false)"type="radio" name="tipoLogradouro">Rodovia</label>
                                <label class="radio-inline col-lg-3"><input ng-model="endereco.tipo_logradouro" required ng-value="RUA" ng-checked="(produto.tipo_logradouro == false)"type="radio" name="tipoLogradouro">Rua</label>
                                <label class="radio-inline col-lg-3"><input ng-model="endereco.tipo_logradouro" required ng-value="VIA" ng-checked="(produto.tipo_logradouro == false)"type="radio" name="tipoLogradouro">Via</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-3" for="inputLogradouro">Logradouro</label>
                            <div class="col-lg-9">
                                <input ng-model="endereco.logradouro" type="text" class="form-control" id="inputLogradouro" placeholder="15th street">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-3" for="inputNumero">Numero</label>
                            <div class="col-lg-9">
                                <input ng-model="endereco.numero" type="text" class="form-control" id="inputNumero" placeholder="555">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-3" for="inputCidade">Cidade</label>
                            <div class="col-lg-9">
                                <input ng-model="endereco.cidade" type="text" class="form-control" id="inputCidade" placeholder="New York">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-3" for="inputEstado">Estado</label>
                            <div class="col-lg-9">
                                <input ng-model="endereco.estado" type="text" class="form-control" id="inputEstado" placeholder="NY">
                                <br />
                                <button type="button" class="btn btn-primary pull-right" ng-click="formCadEndSave(endereco)">Salvar</button> 
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-4 col-lg-offset-7">
                                <button type="submit" id="btnCadastrarCategoria" class="btn btn-primary btn-lg btn-block" data-dismiss="modal" ng-click="cadastrarCategoria(categoria, formCadastroCategoria.$valid)">Cadastrar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!--fim modal cadastrar -->
