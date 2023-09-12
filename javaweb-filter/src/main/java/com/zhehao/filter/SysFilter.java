package com.zhehao.filter;

import com.zhehao.util.Constant;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 鉴权，如果Session的USER_SESSION为空，那么跳转回登录页
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getSession().getAttribute(Constant.USER_SESSION) == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
