package org.imdbcompany.imdbservice.controller;

import org.imdbcompany.imdbservice.model.User;
import org.imdbcompany.imdbservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //display list of users
    @GetMapping("/users")
    public String viewHomePage(Model model){
        model.addAttribute("listUsers", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/users/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/users/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/users/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        this.userService.deleteUserById(id);
        return "redirect:/users";
    }
}
