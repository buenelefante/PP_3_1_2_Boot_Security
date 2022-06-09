package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kata.spring.boot_security.demo.entity.User;


public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);
    User findByEmail(String email);

}
