package com.example.springboot_mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController //This has to be "RestController", "Controller" doesn't work
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public Iterable<User> getAllUsers(){
        return service.getAllUsers();
    }

    @PostMapping("/add-with-param")
    public @ResponseBody
    String addUserParam(@RequestParam String name, @RequestParam int age){
        return service.addUserParam(name, age);
    }

    @PostMapping("/add-with-json")
    public Response addUserJson(@RequestBody User user){
        return service.addUserJson(user);
    }
}
