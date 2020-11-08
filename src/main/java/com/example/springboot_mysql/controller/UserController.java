package com.example.springboot_mysql.controller;

import com.example.springboot_mysql.models.User;
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

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id){
        return service.getUserById(id);
    }

    @PostMapping("/add-with-param")
    public Response addUserParam(@RequestParam String username, @RequestParam String password){
        return service.addUserParam(username, password);
    }

    @PostMapping("/add-with-json")
    public Response addUserJson(@RequestBody User user){
        if(StringUtils.isEmpty(user.getUsername())){
            throw new InvalidFieldException("Name is required.");
        }
        return service.addUserJson(user);
    }

    @DeleteMapping("/{id}")
    public Response deleteUserById(@PathVariable long id){
        return service.deleteUserById(id);
    }

}
