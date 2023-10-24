package com.zhehao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/h1")
    public String hello(Model model) {
        // 使用Model对象封装对象
        model.addAttribute("msg", "Hello, SpringMVC");
        // 直接通过return封装要跳转的视图，视图解析器将其解析为/WEB-INF/jsp/hello.jsp
        return "hello";
    }

    // @RequestMapping可以处理所有类型的HTTP请求（GET/POST）
    @RequestMapping("/h2")
    public String hello2(Model model) {
        model.addAttribute("msg", "Hello, SpringMVC2");
        // 视图可以复用，hello2和hello都使用/WEB-INF/jsp/hello.jsp
        return "hello";
    }

    // 请求http://localhost:8080/springmvc-02-1.0-SNAPSHOT/hello/add?a=1&b=2
    @RequestMapping(value = "/add")
    public String add(Model model, int a, int b) {
        // 传参的a和b与方法的参数名一致，可以直接接收
        int sum = a + b;
        model.addAttribute("msg", "结果为：" + sum);
        return "hello";
    }

    // 可通过method参数限定请求类型
    // @PathVariable注解可以将URI模版变量的值赋给方法参数，RestFul风格使用路径传参
    @RequestMapping(value = "/add1/{a}/{b}", method = RequestMethod.GET)
    public String add1(Model model, @PathVariable int a, @PathVariable int b) {
        int sum = a + b;
        model.addAttribute("msg", "结果为：" + sum);
        return "hello";
    }

    // @PostMapping是@RequestMapping的派生注解，是@RequestMapping(method = RequestMethod.POST)的缩写
    // 如果用Get请求该接口会报405
    @PostMapping("/add2")
    public String add2(Model model, int a, int b) {
        int sum = a + b;
        model.addAttribute("msg", "结果为：" + sum);
        return "hello";
    }

    @GetMapping("/forward")
    public String testForward(Model model) {
        model.addAttribute("msg", "forward");
        // return后经过视图解析器，默认进行forward转发到hello.jsp
        return "hello";
    }

    @GetMapping("/redirect")
    public String testRedirect(Model model) {
        model.addAttribute("msg", "redirect");
        // 可以不使用默认的forward转发，而使用redirect进行重定向
        return "redirect:/index.jsp";
    }
}
