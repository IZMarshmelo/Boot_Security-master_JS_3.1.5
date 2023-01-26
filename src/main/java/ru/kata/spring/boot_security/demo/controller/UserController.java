package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.kata.spring.boot_security.demo.dto.UserDto;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/user")
    public String getUserPage(Principal principal, @ModelAttribute("userForReg") UserDto userForReg, Model model) {
        model.addAttribute("user", userService.findByEmail(principal.getName()).get());
        model.addAttribute("allRoles", roleService.getAllRoles());
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

