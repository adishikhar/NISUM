package com.nisum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        if ("admin".equals(username) && "secret123".equals(password)) {

            out.println("<h2>Login Successful</h2>");
            out.println("<p>Welcome, Aditya </p>");

        } else {

            out.println("<h2>Login Failed</h2>");
            out.println("<p>Invalid username or password.</p>");

        }
    }
}
