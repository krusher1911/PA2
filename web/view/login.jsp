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
<link href="resources/css/default.css" rel="stylesheet" type="text/css"/>
<script src="resources/js/bootstrap.js" type="text/javascript"></script>
<script src="resources/js/jquery-1.11.2.min.js" type="text/javascript"></script>
</head>
   <jsp:include page="master/header.jspf"/>
 
   <jsp:include page="master/footer.jspf"/>
 
   <div class="container">
        
        <div class="container">
            
            <form class="form-signin" role="form">
                <center><h2 class="form-signin-heading" contenteditable="false">Login</h2></center>

               <input class="form-control" placeholder="Email address" required="" autofocus="" type="text" contenteditable="false">
               <input class="form-control" placeholder="Password" required="" type="password" contenteditable="false">
               <label class="checkbox">
                   <input value="remember-me" class="" type="checkbox">Lembre-me</label>
               <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
           </form>
            
        </div>
        
    </div>
</body>
</html>
