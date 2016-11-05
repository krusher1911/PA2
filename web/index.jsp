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
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
        <script src="resources/js/bootstrap.js" type="text/javascript"></script>
        <script src="resources/js/customScripts.js" type="text/javascript"></script>
        <script src="resources/js/app.js" type="text/javascript"></script>
        <script src="resources/js/ajax.js" ></script>
    </head>
    <body ng-app="myModule">
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
        <div ng-controller="myController" class="container-fluid">
            <div class="row">
                <div class="list col-md-2">
                    <a href="#" class="list-group-item" ng-click="togglePri()"><strong><center>Principal</center></strong></a>
                    <a href="#" class="list-group-item" ng-click="toggleMov()"><strong><center>Movimentações</center></strong></a>
                    <a href="#" class="list-group-item" id="menuProdutos" ng-click="togglePro()" ng-click="goBack()"><strong><center>Produtos</center></strong></a>
                </div>
                <div class="col-md-10" ng-show="toggled==1">
                    <div id="principal" class="fade in active">
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
                        </div>
                    </div>
                </div>
                <div class="col-md-10" ng-show="toggled==2">
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
                                </thead>
                                <tbody>
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
                <div class="col-md-10" ng-show="toggled==3">
                    <jsp:include page="contentProduto.jsp" />
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
