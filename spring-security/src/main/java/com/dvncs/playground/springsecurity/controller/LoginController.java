package com.dvncs.playground.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/showLogin")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/showMain")
    public String showMain() {
        return "redirect:/main.html";
    }

    @RequestMapping("/showError")
    public String showError() {
        return "redirect:/error.html";
    }
}
