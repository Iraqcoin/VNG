<%-- 
    Document   : index
    Created on : May 10, 2015, 11:41:43 PM
    Author     : HoaiBao
--%>

<%@page import="org.apache.thrift.protocol.TProtocol"%>
<%@page import="Common.ThriftInterface.UserService"%>
<%@page import="org.apache.thrift.protocol.TBinaryProtocol"%>
<%@page import="org.apache.thrift.transport.TTransportException"%>
<%@page import="org.apache.thrift.transport.TTransport"%>
<%@page import="org.apache.thrift.transport.TSocket"%>
<%@page import="Common.ThriftInterface.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    if (session.getAttribute("user") != null) {
        User u = (User)session.getAttribute("user");
        request.setAttribute("us", u);
        request.getRequestDispatcher("/success.jsp").forward(request, response);
       
    }
    Cookie[] cks = request.getCookies();
    boolean found = false;
    User u = null;
    if (cks != null) {
        for (int i = 0; i < cks.length; i++) {
            Cookie ck = cks[i];
            if (ck.getName().equals("username")) {
                String username = ck.getValue();
                TTransport transport = new TSocket("localhost", 9090);
                try {
                    transport.open();
                } catch (TTransportException ex) {

                }
                TProtocol protocol = new TBinaryProtocol(transport);
                UserService.Client client = new UserService.Client(
                        protocol);
              
                client.UpdateVisitor(username);
                  u = client.GetUser(username);
                session.setAttribute("user", u);
                request.setAttribute("us", u);
                transport.close();
                found = true;
            }
        }
    }
    if (found == true) {
        request.getRequestDispatcher("/success.jsp").forward(request, response);
    }
%>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-lg-offset-2">
                    <h1>Login</h1>
                    <span style="color: red;">${error}</span>
                    <form class="form-horizontal" method="post" action="Login">
                        <div class="form-group">
                            <label for="txtUsername" class="col-sm-2 control-label">Username</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="txtUsername" placeholder="Username" name="txtUsername">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="txtPass">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="ckRb" value="1"> Remember me
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-info">Sign in</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
