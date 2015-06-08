/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Common.ThriftInterface.User;
import Common.ThriftInterface.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * @author HoaiBao
 */
@WebServlet(name = "LoginController", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        String username = req.getParameter("txtUsername");
        String passw = req.getParameter("txtPass");
        String ck = req.getParameter("ckRb");
        String redict = "/index.jsp";
        TTransport transport = null;
        if (!username.equals("") && username != null) {
            try {
                
                transport = new TSocket("localhost", 9090);
                try {
                    transport.open();
                } catch (TTransportException ex) {

                }
                TProtocol protocol = new TBinaryProtocol(transport);
                UserService.Client client = new UserService.Client(
                        protocol);
                
                boolean check = client.CheckLogin(username, passw);
                if(check == true)
                {
                    // login success
                    User u = client.GetUser(username);
                    redict = "/success.jsp";
                    HttpSession session = req.getSession();
                    session.setAttribute("user", u);
                    client.UpdateVisitor(u.getUsername());
                    if(ck != null)
                    {
                        Cookie coo = new Cookie("username", u.username);
                        coo.setMaxAge(60*60*24);
                        response.addCookie(coo);
                    }
                    req.setAttribute("us", u);
                }
                else
                    req.setAttribute("error","Username or password not valid");
            } catch (TException x) {
                 Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, x);
            }
            finally{
                if(transport!= null)
                 transport.close();
            }
        }
        req.getRequestDispatcher(redict).forward(req, response);

    }

}
