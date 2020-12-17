package com.example.speedkill.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Order(1)
@WebFilter(urlPatterns = "/*")
public class FilterTest implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("do filter 20201211   111111111");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("end");
    }
}
