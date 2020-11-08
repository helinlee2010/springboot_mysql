package com.example.springboot_mysql;

import com.example.springboot_mysql.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
