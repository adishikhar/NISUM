package com.nisum;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class filter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("Filter is initialized");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        if (req instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) req;
            String url = httpRequest.getRequestURL().toString();
            System.out.println("Incoming request: " + url);
        }

        
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroyed");
    }
}
