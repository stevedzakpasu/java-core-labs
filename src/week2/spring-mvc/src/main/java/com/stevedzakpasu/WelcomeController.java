package com.stevedzakpasu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("message", "Welcome to Spring MVC!");
        return "welcome";
    }



    @PostMapping("/")
    public String greetUser(Model model, @RequestParam("name") String name) {
        model.addAttribute("message", "Welcome, " + name + "!");
        return "welcome";
    }

}