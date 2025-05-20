package com.nisum;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FeedbackServlet extends HttpServlet {

    private List<String> feedbackList;

    @Override
    public void init() throws ServletException {
        // Initialize the feedback list in memory
        feedbackList = new ArrayList<>();
        getServletContext().setAttribute("feedbackList", feedbackList);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String feedback = request.getParameter("feedback");

        // Store feedback in memory
        synchronized (feedbackList) {
            feedbackList.add(feedback);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Thank you for your feedback!</h2>");
        out.println("<p>Your feedback: " + feedback + "</p>");
        out.println("<a href='feedback.html'>Submit another</a><br>");
        out.println("<a href='view-feedback'>View all feedback</a>");
        out.println("</body></html>");
    }
}

