package com.zhehao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/char")
public class CharacterController {
    @RequestMapping("/show")
    public String showInput(Model model, @RequestParam("name") String name) {
        model.addAttribute("msg", name);
        return "hello";
    }
}
