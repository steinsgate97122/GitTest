package com.zhehao.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    // web服务器启动时初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 设置编码
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        // 如果不调用doFilter()，那么过滤器链就会被截断，请求不会到达目标Servlet或资源
        filterChain.doFilter(servletRequest, servletResponse);
    }

    // web服务器关闭时销毁
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
