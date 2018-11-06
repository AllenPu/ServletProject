<%-- 
    Document   : search
    Created on : Nov 4, 2018, 8:40:04 PM
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
      <form method ="post" action = "reviewMessage">
        <table border="1">
            <tbody>
                <tr>
                        <td>Movie Name</td>
                        <td><input type="text" name="Name" id="Name" /></td>
                    </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit" name="Submit" />Click here for search</td>
                </tr>
  
                </tbody>
            </table>
        </form>
        
    </body>
</html>
