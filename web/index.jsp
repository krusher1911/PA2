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
        <!--<script src="resources/js/ajax.js" ></script>-->
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
                    <a href="#" class="list-group-item" id="menuPrincipal" ng-click="togglePri()"><strong><center>Principal</center></strong></a>
                    <a href="#" class="list-group-item" ng-click="toggleMov()"><strong><center>Movimentações</center></strong></a>
                    <a href="#" class="list-group-item" id="menuProdutos" ng-click="togglePro()"><strong><center>Produtos</center></strong></a>
                    <a href="#" class="list-group-item" id="menuCategorias" ng-click="carregarCategorias(true)"><strong><center>Categorias</center></strong></a>
                    <a href="#" class="list-group-item" id="menuUnidades" ng-click="carregarUnidades(true)"><strong><center>Unidades</center></strong></a>
                </div>
                <div class="col-md-10" ng-show="toggled==1">
                    <jsp:include page="contentPrincipal.jsp" />
                </div>
                <div class="col-md-10" ng-show="toggled==2">
                    <jsp:include page="contentMovimentacao.jsp" />
                </div>
                <div class="col-md-10" ng-show="toggled==3">
                    <jsp:include page="contentProduto.jsp" />
                </div>
                <div class="col-md-10" ng-show="toggled==4">
                    <jsp:include page="contentCategoria.jsp" />
                </div>
                <div class="col-md-10" ng-show="toggled==5">
                    <jsp:include page="contentUnidade.jsp" />
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
