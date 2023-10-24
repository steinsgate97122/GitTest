package com.zhehao.controller;

import com.zhehao.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
public class ParameterController {
    // ......?a=1&b=2
    @RequestMapping(value = "/add")
    public String param1(Model model, int a, int b) {
        // 传参的a和b与方法的参数名一致，可以直接接收
        int sum = a + b;
        model.addAttribute("msg", a + "+" + b + "=" + sum);
        return "hello";
    }

    // ......?p1=2&p2=3
    @RequestMapping(value = "/add2")
    public String param2(Model model, @RequestParam("p1") int a, @RequestParam("p2") int b) {
        // 传参与方法参数不一样时，使用@RequestParam转换
        // 传参与方法参数一样时，也建议使用@RequestParam标记该参数来自前端
        int sum = a + b;
        model.addAttribute("msg", a + "+" + b + "=" + sum);
        return "hello";
    }

    // 使用对象接收参数时，前端传递的参数和对象的属性必须一致
    // http://localhost:8080/springmvc-02-1.0-SNAPSHOT/param/add3?name=zhehao&id=1&age=26
    @RequestMapping(value = "/add3")
    public String param3(Model model, User user) {
        model.addAttribute("msg", user.toString());
        return "hello";
    }

    // ModelMap和Model类似，也可以在Controller方法中传递数据到视图，一般情况下用Model就行
    // ModelMap的功能更强，除了Model的方法外，还可以使用LinkedHashMap的所有方法，例如put get size entrySet等
    @RequestMapping(value = "/add4")
    public String param4(ModelMap model, @RequestParam("a") int a, @RequestParam("b") int b) {
        int sum = a + b;
        model.put("msg", a + "+" + b + "=" + sum);
        return "hello";
    }
}
