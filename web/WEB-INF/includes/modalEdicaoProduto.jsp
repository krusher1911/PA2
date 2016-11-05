<!-- Conteudo do modal editar -->
<div class="modal fade" id="modalEditar" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <center><h4 class="modal-title">Editar de Produto</h4></center>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="ProdutoController" >
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputId">ID</label>
                        <div class="col-lg-10">
                            <input class="form-control" id="inputId" name="id" placeholder="" type="text" data-toggle="tooltip" data-placement="top" title="ID" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputDescricao">Descri��o</label>
                        <div class="col-lg-10">
                            <input class="form-control" id="inputDescricao" name="descricao" placeholder="${produto.descricao}" type="text" data-toggle="tooltip" data-placement="top" title="Descri��o">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputUnidade">Unidade</label>
                        <div class="col-lg-10">
                            <!--<input class="form-control" id="inputUnidade" name="unidade" placeholder="Unidade" type="text" data-toggle="tootip" data-placement="top" title="Unidade">-->
                            <select class="form-control" name="unidades" id="unidades">
                                <option value =""></option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputFracionavel">Fracion�vel</label>
                        <div class="col-lg-6">
                            <label class="radio-inline"><input type="radio" id="true">Sim</label>
                            <label class="radio-inline"><input type="radio" id="false">N�o</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputTipo">Tipo</label>
                        <div class="col-lg-10">
                            <input class="form-control" id="inputTipo" name="tipo" placeholder="Tipo" type="text" data-toggle="tooltip" data-placement="top" title="Tipo">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputCodigoNcm">C�digo NCM</label>
                        <div class="col-lg-10">
                            <input class="form-control" id="inputCodigoNcm" name="codigoNcm" placeholder="C�digo NCM" type="text" data-toggle="tooltip" data-placement="top" title="C�digo NCM">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputCategoria">Categoria</label>
                        <div class="col-lg-10">
                            <!--<input class="form-control" id="inputCategoria" name="categoria" placeholder="Categoria" type="text" data-toggle="tootip" data-placement="top" title="Categoria">-->
                            <select class="form-control" name="categorias" id="categorias">
                                <option value =""></option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-4 col-lg-offset-7">
                                <button type="submit" class="btn btn-primary btn-lg btn-block active" >Salvar</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>
<!--fim modal-->
