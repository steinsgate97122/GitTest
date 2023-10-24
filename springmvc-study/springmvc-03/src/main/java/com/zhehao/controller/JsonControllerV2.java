package com.zhehao.controller;

import com.zhehao.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @RestController是一个组合注解，相当于@Controller加上@ResponseBody
// 类上加了@RestController后，方法上不再需要显示地添加@ResponseBody
@RestController
@RequestMapping("/json2")
public class JsonControllerV2 {
    @RequestMapping(value = "/t1")
    public User test1() {
        return new User(3, "阿黄", 25);
    }

    @GetMapping(value = "/t2")
    public List<User> test2() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "阿浩", 26));
        userList.add(new User(2, "超超", 28));
        userList.add(new User(1, "阿黄", 27));

        return userList;
    }

    @GetMapping(value = "/t3")
    public Date test3() {
        Date date = new Date();
        // 直接返回是毫秒数
        return date;
    }

    @GetMapping(value = "/t4")
    public String test4() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateFormat.format(date);
        return dateStr;
    }
}
