package com.example.springboot_mysql;

import com.example.springboot_mysql.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public Iterable<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Response addUserParam(String name, int age){
        User u = new User();
        u.setName(name);
        u.setAge(age);
        userRepo.save(u);
        return new Response("A new user from param was added!", Boolean.TRUE);
    }

    public Response addUserJson(User user) {
        userRepo.save(user);
        return new Response("A new users with name: " + user.getName()+ " from JSON request body was added", Boolean.TRUE);
    }
}
