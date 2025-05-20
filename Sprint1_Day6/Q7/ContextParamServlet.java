package com.nisum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ContextParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        ServletContext context = getServletContext();

        String appTitle = context.getInitParameter("appTitle");


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();


        out.println("<h2>Title of Context Parameter</h2>");
        out.println("<p><strong>App Title:</strong> " + appTitle + "</p>");

    }
}
