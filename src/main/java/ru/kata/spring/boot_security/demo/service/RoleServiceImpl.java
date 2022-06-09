package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.entity.Role;

import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void createRoles(Set<Role> roles) {
        roleRepository.saveAll(roles);
    }

    @Override
    public Set<Role> getAllRoles() {
        Iterable<Role> iterable = roleRepository.findAll();
        Set<Role> set = new HashSet<>();
        iterable.forEach(set::add);
        return set;
    }

}
