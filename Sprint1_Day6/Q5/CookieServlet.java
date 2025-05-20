package com.nisum;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();


        Cookie cookie = new Cookie("username", "Aditya_User");
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);


        Cookie[] cookies = req.getCookies();


        out.println("<h2>Cookies</h2>");
        out.println("<p><strong>Setting cookie:</strong> username = Aditya_User</p>");
        out.println("<h3>Cookies received from client:</h3>");

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<p>" + c.getName() + " = " + c.getValue() + "</p>");
            }
        } else {
            out.println("<p>No cookies found.</p>");
        }


    }
}
