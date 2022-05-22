package com.example.pp_3_1_4_1.controller;

import com.example.pp_3_1_4_1.model.User;
import com.example.pp_3_1_4_1.service.RoleService;
import com.example.pp_3_1_4_1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@AllArgsConstructor

@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

//    @GetMapping(value = "/")
//    public String login(@RequestParam(value = "error", required = false) String error,
//                        @RequestParam(value = "logout", required = false) String logout, Model model) {
//        model.addAttribute("error", error != null);
//        model.addAttribute("logout", logout != null);
//        return "login";
//    }

    @GetMapping("/user")
    public String getUser(Model model, Principal principal){
        String username = principal.getName();
        User user = userService.findUserByName(username);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/admin")
    public String getAdmin(Model model, Principal principal){
        String username = principal.getName();
        User user = userService.findUserByName(username);
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", roleService.getAllRole());
        return "admin";
    }
}
