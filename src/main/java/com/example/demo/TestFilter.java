package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("********************  init filter         *******************");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        log.info("********************  before filter         *******************");
        if(request instanceof HttpServletRequest){
            String url = ((HttpServletRequest) request).getRequestURI();
            String queryString  = ((HttpServletRequest) request).getQueryString();
            System.out.println("url::"+url);
            System.out.println("url::"+queryString);
        }
        chain.doFilter(request,response);
        log.info("********************  after filter         *******************");
    }

    @Override
    public void destroy() {
        log.info("********************  destroy filter         *******************");
    }

}