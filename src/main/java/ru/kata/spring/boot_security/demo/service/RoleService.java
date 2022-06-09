package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.Role;


import java.util.Set;

public interface RoleService {
    void createRoles(Set<Role> roles);
    Set<Role> getAllRoles();
}
