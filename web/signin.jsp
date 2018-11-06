<%-- 
    Document   : signin
    Created on : Nov 4, 2018, 4:19:16 PM
    Author     : ruizhipu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
       <body>

        <h2>Add</h2>
        <form method = "post" action="addmovie" id="loginfrm">
            <input type="hidden" name="log" />
            <table border="1">
                <tbody>
                    <tr>
                        <td>Id</td>
                        <td><input type="text" name="Id" id="movieId" /></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="Name" id="movieName" /></td>
                    </tr>
                    <tr>
                        <td>Time</td>
                        <td><input type="text" name="Time" id="Time" /></td>
                    </tr>
                     <tr>
                        <td></td>
                        <td><input type="submit" name="submit" value="update" id="submit" /> 
                    </tr>
                </tbody>
            </table>
        </form>

    </body>
</html>
