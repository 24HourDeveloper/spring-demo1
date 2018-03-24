package com.aandmcoding.springdemo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    private Animal animal = new Animal("Ant", "Has for legs");

    @RequestMapping("/")
    public String getWord(Model model){
        model.addAttribute("word", animal.getName());
        return "index";
    }

    @RequestMapping("/animal")
    public String getWords(Model model){
        model.addAttribute("word", animal.getName());
        return "index";
    }
}
