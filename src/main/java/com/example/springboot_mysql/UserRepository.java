package com.example.springboot_mysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {
    public List<User> findByName(String name);

    public List<User> findByAge(int age);
}
