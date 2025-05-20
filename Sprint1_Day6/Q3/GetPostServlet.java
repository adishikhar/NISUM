package com.nisum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class GetPostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();



        out.println("<h2>doGet() method called</h2>");
        out.println("<form method='post' action='getpost'>");
        out.println("Name: <input type='text' name='username'/> <br/>");
        out.println("<input type='submit' value='Submit via POST'/>");
        out.println("</form>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        String name = request.getParameter("username");

        // Display result
        out.println("<html><body>");
        out.println("<h2>doPost() method called</h2>");
        out.println("<p>Welcome, " + (name != null ? name : "Guest") + "</p>");
        out.println("</body></html>");
    }
}
