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
    public String eatSandwich(@RequestParam (value = "sandwich1") String sandwich1,
                              @RequestParam (value = "sandwich2") String sandwich2,
                              @RequestParam (value = "sandwich3") String sandwich3,
                              @RequestParam (value = "sandwich4") String sandwich4,
                              Model model){
        String result = "Eat Sandwich with " + sandwich1 + " "+ sandwich2+ " "+ sandwich3+ " "+ sandwich4;
        model.addAttribute("result",result);
        return "result";
    }
}
