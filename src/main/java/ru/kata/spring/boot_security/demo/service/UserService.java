package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.User;


import java.util.Optional;

public interface UserService {

    void createUser(User user);
    Iterable<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(User user);
    Optional<User> getUserById(Long id);
}
