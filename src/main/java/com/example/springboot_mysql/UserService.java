package com.example.springboot_mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public Iterable<User> getAllUsers(){
        return userRepo.findAll();
    }

    public String addUserParam(String name, int age){
        User u = new User();
        u.setName(name);
        u.setAge(age);
        userRepo.save(u);
        return "A new user was added!";
    }

    public Response addUserJson(User user) {
        userRepo.save(user);
        return new Response("A new users with name: " + user.getName()+ " from JSON request body was added", Boolean.TRUE);
    }
}
