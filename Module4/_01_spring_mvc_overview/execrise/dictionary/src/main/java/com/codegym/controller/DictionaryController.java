package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping
    public String showForm(){
        return "formDictionary";
    }
    @GetMapping(value="research")
    public String researchDictionary(@RequestParam(value = "dictionary") String name,
                                     Model model){
        String result = this.iDictionaryService.getResearch(name);
        if(result==null){
            result = "Không tìm thấy kết quả";
        }
        model.addAttribute("result",result);
        return "formDictionary";
    }
}
