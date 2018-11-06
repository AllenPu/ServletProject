<%-- 
    Document   : movielist
    Created on : Nov 4, 2018, 2:30:33 PM
    Author     : ruizhipu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/moviecss.css" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body >
        <div class="container background">
            <div id="login-row" class="row justify-content-center align-items-center">
        
        <h2>Login</h2>
         <div id="login-column" class="col-md-6">
                <div class="box">
                    <div class="shape1"></div>
                    <div class="shape2"></div>
                    <div class="shape3"></div>
                    <div class="shape4"></div>
                    <div class="shape5"></div>
                    <div class="shape6"></div>
                    <div class="shape7"></div>
                    <div class="float">
        <form method = "post" action="movie" id="loginfrm" class="form">
            <input type="hidden" name="log" />
                <tbody>
                    <div class="form-group">
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="name" id="username" /></td>
                    </tr>
                    </div>
                    <div class="form-group">
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" id="password" /></td>
                    </tr>
                    </div>
                    <div class="form-group">
                    <tr>
                        <td>Here to login</td>
                        <td><input type="submit" name="Login" value="Login" id="submit" /></td>     
                    </tr>
                    </div>
                    <div class="form-group">
                    <tr>
                        <td>Here to add movie</td>                
                        <td> <a href="signin.jsp" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Add Movie</a></td>
                    </tr>
                    </div>
                    <div class="form-group">
                    <tr>
                        <td>Ranking Movie</td>
                        <td><a href="rankedlist.jsp" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Ranking</a></td>
                    </tr>
                    </div>
                </tbody>
           
        </form>
        </div>
       
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
