package com.example.springboot_mysql;

import com.example.springboot_mysql.models.User;
import com.example.springboot_mysql.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author helinli
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public Iterable<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Response addUserParam(String username, String password){
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        userRepo.save(u);
        return new Response("A new user from param was added!", Boolean.TRUE);
    }

    public Response addUserJson(User user) {
        userRepo.save(user);
        return new Response("A new users with name: " + user.getUsername()+ " from JSON request body was added", Boolean.TRUE);
    }

    public User getUserById(long id) {
        return userRepo.findById(id).orElse(null);
    }
    public Response deleteUserById(long id){
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return new Response("User was deleted.", Boolean.TRUE);
        }
        return new Response("User was not found.", Boolean.FALSE);
    }
}
