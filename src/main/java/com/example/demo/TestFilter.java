package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = {"/api/user/*","/user/*"}) //빈 이용 필터 url여기다 적어 적용 메인이 있은 클래스에 @ServletComponentScan 붙여야함
public class TestFilter implements Filter {


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