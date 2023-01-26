package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.security.Principal;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public String getUserPage(Model model, Principal principal) {
        model.addAttribute("user", userService.findByEmail(principal.getName()));
        return "user-page";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "login")
    public String loginPage() {
        return "redirect:/login";
    }

}

