<%-- 
    Document   : success
    Created on : May 10, 2015, 11:24:14 PM
    Author     : HoaiBao
--%>

<%@page import="Common.ThriftInterface.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${us.username}!</h1>
                <p>Visitor Number : ${us.visitor}</p>
                <p><a class="btn btn-primary btn-lg"  href="Logout" role="button">LOgout</a></p>
            </div>
        </div>


    </body>
</html>
