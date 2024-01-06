package com.example.healthfitnessclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "loginPage";
    }
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }

}
