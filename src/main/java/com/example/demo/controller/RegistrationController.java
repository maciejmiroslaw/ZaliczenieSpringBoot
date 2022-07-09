package com.example.demo.controller;

import com.example.demo.entity.Authority;
import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private final UserService userService;


    public RegistrationController(UserService userService){
        this.userService = userService;
    }
    @GetMapping(value="/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping(value="/register")
    public String saveUser(@ModelAttribute("user") User user, Model model){
        String validator = validate(user);
        if (!validator.isEmpty()){
            model.addAttribute("validator", validator);
            return "register";
        }
        user.getAuthorities().add(new Authority(user, "USER"));
        userService.saveUser(user);
        return "redirect:/login";
    }
    private String validate(User user){
        if (userService.getUser(user.getUsername()) != null) {
            return "uzytkownik o takiej nazwie istnieje";
        }
        else if (user.getUsername().isEmpty() || user.getPassword().isEmpty()){
            return "wypełnij wszystkie pola";
        }
        return "";
    }

}
