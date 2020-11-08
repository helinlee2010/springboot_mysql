package com.example.springboot_mysql;

import com.example.springboot_mysql.models.MyUserDetails;
import com.example.springboot_mysql.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepo;

    public MyUserDetailsService() {
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("User not found.");
        }

        return new MyUserDetails(user);
    }
}
