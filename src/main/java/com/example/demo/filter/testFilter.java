package com.example.demo.filter;

import javax.servlet.*;
import java.io.IOException;

public class testFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("testFilter");
    }
}
