package com.nisum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.regex.Pattern;

public class succ_err extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("username");
        String email = req.getParameter("email");

        resp.setContentType("text/html");

        if (name == null || name.trim().isEmpty() || email == null ) {
            resp.getWriter().println("<h2>Invalid input.</h2>");
        } else {
            resp.getWriter().println("<h2>Form submitted successfully!</h2>");
            resp.getWriter().println("<p>Name: " + name + "</p>");
            resp.getWriter().println("<p>Email: " + email + "</p>");
        }
    }
}
