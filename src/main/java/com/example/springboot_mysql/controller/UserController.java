package com.example.springboot_mysql.controller;

import com.example.springboot_mysql.User;
import com.example.springboot_mysql.UserService;
import com.example.springboot_mysql.exception.InvalidFieldException;
import com.example.springboot_mysql.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
        if(StringUtils.isEmpty(user.getName())){
            throw new InvalidFieldException("Name is required.");
        }
        return service.addUserJson(user);
    }
}
