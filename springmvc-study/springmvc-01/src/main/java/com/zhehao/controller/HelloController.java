package com.zhehao.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 实际开发时会用Controller注解
public class HelloController implements Controller {

    @Override
    // 该方法需要返回一个ModelAndView
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        // 正常情况下这里还需要调用业务层

        // 封装对象，value可以为空
        mv.addObject("msg","HelloSpringMVC!");
        // 封装要跳转的视图
        mv.setViewName("hello"); //: /WEB-INF/jsp/hello.jsp
        return mv;
    }
}
