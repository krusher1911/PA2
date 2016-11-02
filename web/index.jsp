<%@page import="java.time.LocalDate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto UNA</title>

        <link href="resources/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/cssLayout.css" rel="stylesheet" type="text/css"/>
        <script src="resources/js/jquery-1.11.2.min.js" type="text/javascript"></script>
        <script src="resources/js/bootstrap.js" type="text/javascript"></script>
        <script src="resources/js/customScripts.js" type="text/javascript"></script>

        <script src="resources/js/ajax.js" ></script>
    </head>
    <body>
        <div>
            <header id="top">
                <nav class="navbar navbar-default navbar-fixed-top">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navHeaderCollapse">

                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>

                            </button>

                            <a href="IndexController" class="navbar-brand">projeto UNA</a>
                        </div>
                        <div class="collapse navbar-collapse navHeaderCollapse">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a>${usuario}</a></li>
                                <li><a href="LoginController"><span class="glyphicon glyphicon-user"></span>Sair</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
        </div>
        <div class="container-fluid">
                <div class="row">
                        <div class="col-md-2">
                                <ul class="nav nav-pills nav-stacked">
                                    <li class="active"><a id="menuPrincipal" data-toggle="tab" href="#principal">Principal</a></li>
                                    <li><a id="menuMovimentacoes" data-toggle="tab" href="#movimentacoes">Movimentações</a></li>
                                    <li><a id="menuProdutos" data-toggle="tab">Produtos</a></li>
                                </ul>
                        </div>
                        <div class="col-md-10">
                            <div class="tab-content">
                                <!-- conteudo principal -->
                                <div id="principal" class="tab-pane fade in active">
                                        <div class="panel panel-primary">
                                            <div class="panel panel-heading">
                                                                <center>
                                                                <h3 class="panel-title">Principal</h3></center>
                                                        </div>
                                                        <div class="panel-body">
                                                            <div class="row">
                                                                    <div class="col-md-offset-1">
                                                                    <label class="checkbox-inline"><input type="checkbox" value="">Receita</label>
                                                                    <button type="submit" method="post" class="btn btn-primary">Pesquisar</button>
                                                                    </div></br>
                                                                    <div class="col-md-offset-1">
                                                                    <label class="checkbox-inline"><input type="checkbox" value="">Option 2</label>
                                                                    <button type="submit" method="post" class="btn btn-primary">Pesquisar</button>
                                                                    </div>
                                                            </div>
                                                        </div>
                                                        <div class="panel-footer">
                                                                <center>
                                                                        <nav aria-label="Page navigation">
                                                                                <ul class="pagination">
                                                                                        <li>
                                                                                        <a href="#" aria-label="Previous">
                                                                                        <span aria-hidden="true">&laquo;</span>
                                                                                        </a>
                                                                                        </li>
                                                                                    <li><a href="#">1</a></li>
                                                                                    <li><a href="#">2</a></li>
                                                                                    <li><a href="#">3</a></li>
                                                                                    <li><a href="#">4</a></li>
                                                                                    <li><a href="#">5</a></li>
                                                                                        <li>
                                                                                                <a href="#" aria-label="Next">
                                                                                                <span aria-hidden="true">&raquo;</span>
                                                                                                </a>
                                                                                        </li>
                                                                                </ul>
                                                                        </nav>
                                                                </center>
                                                        </div>
                                                </div>
                                    </div>
                                <!-- fim conteudo principal -->


                                <!-- conteudo movimentações -->
                                    <div id="movimentacoes" class="tab-pane fade">
                                                <div class="panel panel-primary">
                                                        <div class="panel panel-heading">
                                                                <center>
                                                                        <h3 class="panel-title">Movimentações</h3>
                                                                </center>
                                                        </div>
                                                        <div class="panel-body">
                                                                Panel content
                                                        </div>
                                                        <div class="panel-footer">
                                                                <center>
                                                                        <nav aria-label="Page navigation">
                                                                                <ul class="pagination">
                                                                                        <li>
                                                                                                <a href="#" aria-label="Previous">
                                                                                                <span aria-hidden="true">&laquo;</span>
                                                                                                </a>
                                                                                    </li>
                                                                                    <li><a href="#">1</a></li>
                                                                                    <li><a href="#">2</a></li>
                                                                                    <li><a href="#">3</a></li>
                                                                                    <li><a href="#">4</a></li>
                                                                                        <li><a href="#">5</a></li>
                                                                                        <li>
                                                                                                <a href="#" aria-label="Next">
                                                                                                <span aria-hidden="true">&raquo;</span>
                                                                                                </a>
                                                                                        </li>
                                                                                </ul>
                                                                        </nav>
                                                                </center>
                                                        </div>
                                                </div>
                                        </div>
                                    <!-- fim conteudo movimentações -->


                                    <!-- Conteudo produtos -->
                                        <div id="produtos" class="tab-pane fade">
                                        <div class="panel panel-primary">
                                                        <div class="panel panel-heading">
                                                            <center><h3 class="panel-title">Produtos</h3></center>
                                                            <button id="cadastrarProduto" type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#modalCadastrar"><span class="glyphicon glyphicon-plus"></span></button>
                                                        </div>
                                                        <div class="panel-body">
                                                                <table id="jsGrid" class="table" action="ajax.">
                                                                    <thead class="thead-inverse">
                                                                        <tr>
                                                                            <th>Código</th>
                                                                            <th>Descrição</th>
                                                                            <th>Unidade de Medida</th>
                                                                            <th>Fracionavel?</th>
                                                                            <th>Tipo</th>
                                                                            <th>Código NCM</th>
                                                                            <th>Categoria</th>
                                                                            <th>Ações</th>
                                                                            <th> </th>
                                                                        </tr>
                                                                        <c:forEach var="produto" items="${produtos}">
                                                                            <tr>
                                                                                <td>${produto.getId()}</td>
                                                                                <td>${produto.getDescricao()}</td>
                                                                                <td>${produto.getUnidade().getDescricao()}</td>
                                                                                <td>${produto.getPermiteFracionar()}</td>
                                                                                <td>${produto.getTipo()}</td>
                                                                                <td>${produto.getCodigNcm()}</td>
                                                                                <td>${produto.getCategoria().getNome()}</td>
                                                                                <td>
                                                                                    <button id="editarProduto" type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#modalEditar"><span class="glyphicon glyphicon-edit"></span></button>
                                                                                    <button id="removerProduto" type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#modalRemover"><span class="glyphicon glyphicon-remove"></span></button>
                                                                                </td>
                                                                            </tr>
                                                                        </c:forEach>
                                                                    </tbody>
                                                                </table>


                                                                <!-- Conteudo do modal cadastrar -->
                                                                <div class="modal fade" id="modalCadastrar" role="dialog">
                                                                    <div class="modal-dialog">

                                                                        <!-- Modal content-->
                                                                        <div class="modal-content">
                                                                            <div class="modal-header">
                                                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                                                <center><h4 class="modal-title">Cadastro de Produtos</h4></center>
                                                                            </div>
                                                                            <form class="form-group" action="ProdutoController" method="post">
                                                                                <!--<div class="modal-body">-->


                                                                                <div class="form-group">
                                                                                    <label class="col-lg-2 control-label" for="inputDescricao">Descrição</label>
                                                                                    <div class="col-lg-10">
                                                                                        <input class="form-control" id="inputDescricao" name="descricao" placeholder="Descrição" type="text" data-toggle="tootip" data-placement="top" title="Descrição:">
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label class="col-lg-2 control-label" for="inputUnidade">Unidade</label>
                                                                                    <div class="col-lg-10">
                                                                                        <!--<input class="form-control" id="inputUnidade" name="unidade" placeholder="Unidade" type="text" data-toggle="tootip" data-placement="top" title="Unidade">-->
                                                                                        <select name="unidades" id="unidades">
                                                                                            <option value ="">------------------</option>
                                                                                        </select>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label class="col-lg-2 control-label" for="inputPermiteFracionar">Permite Fracionar?</label>
                                                                                    <div class="col-lg-10">
                                                                                        <input class="form-control" id="inputPermiteFracionar" name="permiteFracionar" placeholder="Permite Fracionar?" type="text" data-toggle="tootip" data-placement="top" title="Permite Fracionar?">
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label class="col-lg-2 control-label" for="inputTipo">Tipo</label>
                                                                                    <div class="col-lg-10">
                                                                                        <input class="form-control" id="inputTipo" name="tipo" placeholder="Tipo" type="text" data-toggle="tootip" data-placement="top" title="Tipo">
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label class="col-lg-2 control-label" for="inputCodigNcm">Código NCM</label>
                                                                                    <div class="col-lg-10">
                                                                                        <input class="form-control" id="inputCodigNcm" name="codigoNcm" placeholder="Código NCM" type="text" data-toggle="tootip" data-placement="top" title="Código NCM">
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label class="col-lg-2 control-label" for="inputCategoria">Categoria</label>
                                                                                    <div class="col-lg-10">
                                                                                        <!--<input class="form-control" id="inputCategoria" name="categoria" placeholder="Categoria" type="text" data-toggle="tootip" data-placement="top" title="Categoria">-->
                                                                                        <select name="categorias" id="categorias">
                                                                                            <option value ="">------------------</option>
                                                                                        </select>
                                                                                    </div>
                                                                                </div>
                                                                                <!--                                                                            </div>
                                                                                                                                                            <div class="modal-footer">-->
                                                                                <div class="form-group">
                                                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                                                    <button type="submit" class="btn btn-default" >Salvar</button>
                                                                                </div>
                                                                                <!--</div>-->
                                                                            </form>
                                                                        </div>

                                                                    </div>
                                                                </div>
                                                                <!--fim modal cadastrar -->

                                                                <!-- Conteudo do modal editar -->
                                                                <div class="modal fade" id="modalEditar" role="dialog">
                                                                    <div class="modal-dialog">

                                                                        <!-- Modal content-->
                                                                        <div class="modal-content">
                                                                            <div class="modal-header">
                                                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                                                <center><h4 class="modal-title">Editar de Produto</h4></center>
                                                                            </div>
                                                                            <form class="form-group" action="ProdutoController" >
                                                                                <div class="form-group">
                                                                                    <label class="col-lg-2 control-label" for="inputId">ID</label>
                                                                                    <div class="col-lg-10">
                                                                                        <input class="form-control" id="inputId" name="id" placeholder="${produto.descricao}" type="text" data-toggle="tootip" data-placement="top" title="ID">
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label class="col-lg-2 control-label" for="inputDescricao">Descrição</label>
                                                                                    <div class="col-lg-10">
                                                                                        <input class="form-control" id="inputDescricao" name="descricao" placeholder="${produto.descricao}" type="text" data-toggle="tootip" data-placement="top" title="Descrição:">
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label class="col-lg-2 control-label" for="inputUnidade">Unidade</label>
                                                                                    <div class="col-lg-10">
                                                                                        <!--<input class="form-control" id="inputUnidade" name="unidade" placeholder="Unidade" type="text" data-toggle="tootip" data-placement="top" title="Unidade">-->
                                                                                        <select name="unidades" id="unidades">
                                                                                            <option value ="">------------------</option>
                                                                                        </select>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label class="col-lg-2 control-label" for="inputPermiteFracionar">Permite Fracionar?</label>
                                                                                    <div class="col-lg-10">
                                                                                        <input class="form-control" id="inputPermiteFracionar" name="permiteFracionar" placeholder="Permite Fracionar?" type="text" data-toggle="tootip" data-placement="top" title="Permite Fracionar?">
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label class="col-lg-2 control-label" for="inputTipo">Tipo</label>
                                                                                    <div class="col-lg-10">
                                                                                        <input class="form-control" id="inputTipo" name="tipo" placeholder="Tipo" type="text" data-toggle="tootip" data-placement="top" title="Tipo">
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label class="col-lg-2 control-label" for="inputCodigNcm">Código NCM</label>
                                                                                    <div class="col-lg-10">
                                                                                        <input class="form-control" id="inputCodigNcm" name="codigoNcm" placeholder="Código NCM" type="text" data-toggle="tootip" data-placement="top" title="Código NCM">
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label class="col-lg-2 control-label" for="inputCategoria">Categoria</label>
                                                                                    <div class="col-lg-10">
                                                                                        <!--<input class="form-control" id="inputCategoria" name="categoria" placeholder="Categoria" type="text" data-toggle="tootip" data-placement="top" title="Categoria">-->
                                                                                        <select name="categorias" id="categorias">
                                                                                            <option value ="">------------------</option>
                                                                                        </select>
                                                                                    </div>
                                                                                </div>
                                                                                <!--                                                                            </div>
                                                                                                                                                            <div class="modal-footer">-->
                                                                                <div class="form-group">
                                                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                                                    <button type="submit" class="btn btn-default" >Salvar</button>
                                                                                </div>
                                                                                <!--</div>-->
                                                                            </form>
                                                                        </div>

                                                                    </div>
                                                                </div>
                                                                <!--fim modal-->

                                                            </div>
                                                        </div>
                                                </div>
                                        </div>

                                        <!-- fim conteudo produtos -->
                                </div>
                        </div>
                </div>
        </div>
        
        <div class = "navbar navbar-default navbar-fixed-bottom">
            <div class = "container-fluid">
                <p class = "navbar-text pull-left">&copy; <% out.print(LocalDate.now().getYear()); %> - Projeto UNA. All rights reserved.</p>
            </div>
        </div>
    </body>
</html>