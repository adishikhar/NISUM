package com.nisum;

import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class DateTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Date now = new Date();


        out.println("<h2>Current Date and Time:</h2>");
        out.println("<p>" + now.toString() + "</p>");
        out.println("</body></html>");
    }
}
