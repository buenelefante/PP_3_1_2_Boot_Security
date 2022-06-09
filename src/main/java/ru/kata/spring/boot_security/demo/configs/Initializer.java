package ru.kata.spring.boot_security.demo.configs;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entity.Role;

import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
@Transactional
public class Initializer {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private Set<Role> rolesSet;

    public Initializer(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostConstruct
    public void initRoles() {
        Role[] rolesArray = new Role[]{new Role("ROLE_ADMIN"), new Role("ROLE_USER")};
        rolesSet = new HashSet<>();
        rolesSet.addAll(Arrays.asList(rolesArray));
        roleRepository.saveAll(rolesSet);
    }
    @PostConstruct
    public void initUsers() {
        User admin = new User("admin", "admin", 50, "admin@admin.com", passwordEncoder.encode("admin"),rolesSet );
        userRepository.save(admin);
    }
}
