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

                        <a href="LoginController" class="navbar-brand">projeto UNA</a>
                    </div>
                </div>
            </nav>
        </header>
        
        <!-- Mensagem de erro -->
        <div class="container">
            <div class="alert alert-danger">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                ${message}
            </div>
        </div>
        
        <!-- Form Entrar -->
        <div class="row">
            <div class="col-md-4 col-md-offset-4 well">
                <center><h1 class="h1">Entrar</h1></center>
                <form class="form-horizontal" action="LoginController" method="post">
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputUsuario">Usuário</label>
                        <div class="col-lg-10">
                            <input class="form-control" id="inputEmail" name="usuario" placeholder="Usuário" type="text" data-toggle="tootip" data-placement="top" title="Informe o usuário de acesso">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label" for="inputSenha">Senha</label>
                        <div class="col-lg-10">
                            <input class="form-control" id="inputSenha" name="senha" placeholder="Senha" type="password" data-toggle="tootip" data-placement="top" title="Informe a senha de acesso"></br>
                        </div>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary pull-right">Entrar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="container">
       
    </div>
    <div class = "navbar navbar-default navbar-fixed-bottom">
        <div class = "container-fluid">
            <p class = "navbar-text pull-left">&copy; Projeto UNA. All rights reserved.</p>
        </div>
    </div>
</body>
</html>