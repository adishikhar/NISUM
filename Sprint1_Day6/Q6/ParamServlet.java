package com.nisum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ParamServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        ServletConfig config = getServletConfig();


        String adminEmail = config.getInitParameter("adminEmail");
        String supportPhone = config.getInitParameter("supportPhone");


        out.println("<h2>Initialization Parameters</h2>");
        out.println("<p>Admin Email: " + adminEmail + "</p>");
        out.println("<p>Support Phone: " + supportPhone + "</p>");

    }
}
