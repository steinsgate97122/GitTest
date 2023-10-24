package com.zhehao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhehao.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class JsonController {
    // produces中指定响应内容类型，包含字符集编码信息
    @RequestMapping(value = "/t1", produces = "application/json;charset=utf-8")
    // @ResponseBody用于指示方法返回的对象应该被写入HTTP响应体中，而不是作为视图名称被解析，通常返回JSON数据
    @ResponseBody
    public String test1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        User user = new User(1, "阿浩", 26);
        String jsonStr = mapper.writeValueAsString(user);

        return jsonStr;
    }

    // springmvc-servlet.xml配置<mvc:annotation-driven>后可直接解决乱码问题，不需要produces参数
    @RequestMapping("/t2")
    // @ResponseBody可直接将对象转换为JSON格式的响应
    @ResponseBody
    public User test2() {
        User user = new User(2, "超超", 27);
        return user;
    }
}
