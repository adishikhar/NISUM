package com.nisum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        
        String message = (String) req.getAttribute("message");

        resp.setContentType("text/html");
        resp.getWriter().println("<h2> Received Message From TargetServlet:</h2>");
        resp.getWriter().println("<p>" + message + "</p>");
    }
}
