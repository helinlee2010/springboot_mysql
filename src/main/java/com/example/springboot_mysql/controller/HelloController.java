package com.example.springboot_mysql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home(){
        return("<h1>Welcome Home</h1>");
    }

    @GetMapping("/hello")
    public String greeting(){
        return "Hello";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return("<h1>Welcome Admin</h1>");
    }


}
