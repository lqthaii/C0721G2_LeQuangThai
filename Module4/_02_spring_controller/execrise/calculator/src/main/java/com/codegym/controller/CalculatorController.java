package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping(value = "calculator")
    private String showForm(){
        return "index";
    }
    @PostMapping(value = "calculator")
    private String calculatorNumber(@RequestParam(name = "number1") double number1,
                                    @RequestParam(name = "number2") double number2,
                                    @RequestParam(name = "calculation") char calculation, Model model){
        double result = 0;
        switch (calculation){
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
        }
        model.addAttribute("result",result);
        return "index";
    }
}
