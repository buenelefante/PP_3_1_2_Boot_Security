package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;


public interface UserService {
    User findById(Long id);

    List<User> getAll();

    User saveUser(User user);

    void deletedById(Long id);

    UserDetails loadUserByUsername(String username);

    void addTestUsers();
}
