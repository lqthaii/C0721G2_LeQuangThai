package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertCurrency {
    @GetMapping(value = "convert")
    private String showFormConvert(){
        return "convertForm";
    }
    @PostMapping(value = "convert")
    private String convertCurrency(@RequestParam(name = "usd") double usd,
                                 Model model){
        final int CONVERT = 23000;
        double vnd = usd * CONVERT;
        model.addAttribute("vnd",vnd);
        return "convertForm";
    }
}
