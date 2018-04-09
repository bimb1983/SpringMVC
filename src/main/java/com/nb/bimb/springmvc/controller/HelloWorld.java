package com.nb.bimb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}: TODO
 *
 * @author :bimb
 * @create :2018-04-04 10:02
 **/
@Controller
@RequestMapping("/Hello")
public class HelloWorld {
    @RequestMapping("/Sayhi")
    public String SayHi(Model model) {
        model.addAttribute("message", "Hello Spring MVC!");
        return "sayhi";
    }
}