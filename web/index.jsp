<%@page import="java.time.LocalDate"%>
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
                                        <li class="active"><a data-toggle="tab" href="#principal">Principal</a></li>
                                        <li><a id="menu1" data-toggle="tab" href="#movimentacoes">Movimentações</a></li>
                                        <li><a data-toggle="tab" href="#produtos">Produtos</a></li>
                                </ul>
                        </div>
                        <div class="col-md-10">
                                <div class="tab-content">
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
                                        <div id="produtos" class="tab-pane fade">
                                                <div class="panel panel-primary">
                                                        <div class="panel panel-heading">
                                                                <center><h3 class="panel-title">Produtos</h3></center>
                                                        </div>
                                                        <div class="panel-body">
                                                                <table class="table">
                                                                        <thead class="thead-inverse">
                                                                            <tr>
                                                                                        <th>#</th>
                                                                                        <th>First Name</th>
                                                                                        <th>Last Name</th>
                                                                                        <th>Username</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <tr>
                                                                                        <th scope="row">1</th>
                                                                                        <td>Mark</td>
                                                                                        <td>Otto</td>
                                                                                        <td>@mdo</td>
                                                                            </tr>
                                                                            <tr>
                                                                                        <th scope="row">2</th>
                                                                                        <td>Jacob</td>
                                                                                        <td>Thornton</td>
                                                                                        <td>@fat</td>
                                                                            </tr>
                                                                            <tr>
                                                                                        <th scope="row">3</th>
                                                                                        <td>Larry</td>
                                                                                        <td>the Bird</td>
                                                                                        <td>@twitter</td>
                                                                            </tr>
                                                                        </tbody>
                                                                </table>
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