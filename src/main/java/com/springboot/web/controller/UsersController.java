package com.springboot.web.controller;

import com.springboot.web.model.User;
import com.springboot.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;



@Controller
public class UsersController {

    private UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printAllUser(ModelMap model) {
        model.addAttribute("users", userService.getListUsers());
        return "users";
    }
    @GetMapping("/new")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }
    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/{id}/update")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "updateUser";
    }
    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
    @GetMapping("/{id}")
    public String showUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "oneUser";
    }
    @GetMapping("/delete/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

}
