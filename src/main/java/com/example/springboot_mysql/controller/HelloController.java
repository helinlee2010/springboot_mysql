package com.example.springboot_mysql.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @GetMapping("/logout-success")
    public String logout(HttpServletResponse response) throws IOException {
        // response.sendRedirect("/");
        return "<h1>Logout Success</h1>";
    }


}
