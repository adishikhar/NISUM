package com.nisum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class sendingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        req.setAttribute("message", "SendingServlet!");


        RequestDispatcher dispatcher = req.getRequestDispatcher("/dest");
        dispatcher.forward(req, resp);
    }
}
