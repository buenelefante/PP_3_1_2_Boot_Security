package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/admin")
    public String userList(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "admin";
    }

    @GetMapping("user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
       userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }



//    @PostMapping("/admin")
//    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
//                              @RequestParam(required = true, defaultValue = "" ) String action,
//                              Model model) {
//        if (action.equals("delete")){
//            userService.deleteUser(userId);
//        }
//        return "redirect:/admin";
//    }
//
//    @GetMapping("/admin/gt/{userId}")
//    public String  gtUser(@PathVariable("userId") Long userId, Model model) {
//        model.addAttribute("allUsers", userService.usergtList(userId));
//        return "admin";
//    }
}
