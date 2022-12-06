package com.example.demo.HelloWorld.filterTest.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author maxiao
 */
@Component
@Log4j2
public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("初始化过滤器：", filterConfig.getFilterName());
    }

    @Override
    public void destroy() {
        log.debug("销毁过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.debug("对请求进行预处理");
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String uri = request.getRequestURI();
        String url = String.valueOf(request.getRequestURL());

        System.out.println("请求接口为：" + uri);
        System.out.println("请求接口为：" + url);

        long startTime = System.currentTimeMillis();

        filterChain.doFilter(servletRequest, servletResponse);

        long endTime = System.currentTimeMillis();

        System.out.println("请求时间为：" + (endTime - startTime));
        
    }
}
