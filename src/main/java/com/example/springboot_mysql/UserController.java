package com.example.springboot_mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    // This doesn't work!!
    // "status": 500, "error": "Internal Server Error"
    @GetMapping("/users")
    public Iterable<User> getAllUsers(){
        return service.getAllUsers();
    }

    // This works
    @PostMapping("/users/add")
    public @ResponseBody
    String addUser(@RequestParam String name, @RequestParam int age){
        return service.addUser(name, age);
    }

}
