package com.binan.buy.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ElmFilter", urlPatterns="/*")
public class ElmFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        //注意：这里设置只允许http://localhost:8081进行跨域访问
        res.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8848");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        res.setHeader("Access-Control-Max-Age", "3628800");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
        chain.doFilter(request, response);
    }
}
