package com.example.judge2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homework")
public class HomeWorkController {
    @GetMapping("/add")
    public String add () {
        return "homework-add";
        //todo: continue
    }
}
