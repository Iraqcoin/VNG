/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoaibao
 */
@WebServlet(name = "LogoutController", urlPatterns = {"/Logout"})
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        request.getSession().invalidate();
        Cookie killMyCookie = new Cookie("username", null);
        killMyCookie.setMaxAge(0);
        response.addCookie(killMyCookie);
        response.sendRedirect("index.jsp");
    }
}
