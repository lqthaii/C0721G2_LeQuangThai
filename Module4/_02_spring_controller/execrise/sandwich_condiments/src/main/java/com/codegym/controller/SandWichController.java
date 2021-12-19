package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandWichController {
    @GetMapping(value = {"","/sandwich"})
    public String showFormSandwich(){
        return "sandwich";
    }
    @PostMapping(value = "sandwich")
    public String eatSandwich(@RequestParam (value = "sandwich") String sandwich,
                              Model model){
        String result = "Eat Sandwich with " + sandwich;
        model.addAttribute("result",result);
        return "result";
    }
}
