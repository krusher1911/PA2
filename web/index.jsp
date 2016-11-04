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
                        <li class="active"><a id="menuPrincipal" data-toggle="tab" class="btn btn-link" href="#principal">Principal</a></li>
                        <li><a id="menuMovimentacoes" data-toggle="tab" class="btn btn-link" href="#movimentacoes">Movimentações</a></li>
                        <li><a id="menuProdutos" data-toggle="tab" class="btn btn-link">Produtos</a></li>
                    </ul>
                </div>
                    <div class="col-md-10">
                        <div class="tab-content">
                            <!-- conteudo principal -->
                            <div id="principal" class="tab-pane fade in active">
                                <div class="panel panel-primary">
                                    <div class="panel panel-heading">
                                        <p class="panel-title" align="center"><strong>Principal</strong></p>
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
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <a id="cadastrarMovimentacao" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalCadastrarMovimentacao"><span class="glyphicon glyphicon-plus"></span></a>
                                                </div>
                                                <div class="col-md-4 ">
                                                        <p class="panel-title" align="center"><strong>Movimentações</strong></p>
                                                </div>
                                                <div class="col-md-4">
                                                    
                                                </div>
                                            </div>
                                        </div>
                                        <div class="panel-body">
                                            <table id="jsGrid" class="table" action="ajax.">
                                                <thead class="thead-inverse">
                                                    <tr>
                                                        <th>Data</th>
                                                        <th>ID Nota</th>
                                                        <th>Descrição</th>
                                                        <th>Quantidade</th>
                                                        <th>Valor Desconto</th>
                                                        <th>Valor Unitário</th>
                                                        <th>Valor Total</th>
                                                        
                                                    </tr>
                                                    <c:forEach var="movimentacao" items="${movimentacoes}">
                                                        <tr>
                                                            <td>${movimentacao.getId()}</td>
                                                            <td>${movimentacao.getDescricao()}</td>
                                                            <td>${movimentacao.getUnidade().getDescricao()}</td>
                                                            <td>${movimentacao.getPermiteFracionar()}</td>
                                                            <td>${movimentacao.getTipo()}</td>
                                                            <td>${movimentacao.getCodigNcm()}</td>
                                                            <td>${movimentacao.getCategoria().getNome()}</td>
                                                            <td>
                                                                <button id="editarProduto" type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modalEditar"><span class="glyphicon glyphicon-edit"></span></button>
                                                                <button id="removerProduto" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalRemover"><span class="glyphicon glyphicon-remove"></span></button>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            <!-- fim conteudo movimentações -->

                            <!-- Conteudo produtos -->
                                <div id="produtos" class="tab-pane fade">
                                <div class="panel panel-primary">
                                    <div class="panel panel-heading">
                                        <div class="row">
                                                <div class="col-md-4">
                                                <a id="cadastrarProduto" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalCadastrar"><span class="glyphicon glyphicon-plus"></span></a>
                                            </div>
                                            <div class="col-md-4 ">
                                                    <p class="panel-title" align="center"><strong>Produtos</strong></p>
                                            </div>
                                            <div class="col-md-4">

                                            </div>
                                        </div>
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
                                                            <button id="editarProduto" type="button" class="editarProduto btn btn-primary btn-sm"><span class="glyphicon glyphicon-edit"></span></button>
                                                            <button id="removerProduto" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalRemover"><span class="glyphicon glyphicon-remove"></span></button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                        
                                        <jsp:include page="WEB-INF/Includes/modalCadatroProduto.jsp"/>

                                        <jsp:include page="WEB-INF/Includes/modalEdicaoProduto.jsp"/>

                                        <jsp:include page="WEB-INF/Includes/modalExclusaoProduto.jsp"/>

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
