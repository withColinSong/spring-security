package com.example.demo.filter;

import javax.servlet.*;
import java.io.IOException;


/**
 * 현재 로그인 했을 때 해당 필터가 걸리게 됨.
 */

public class TestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("testFilter");

        chain.doFilter(request, response);
    }
}
