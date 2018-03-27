package com.aandmcoding.springdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class MainController {
    @Autowired
    private AmRepository amRepository;

    @RequestMapping("/")
    public String getWord(Model model){
        model.addAttribute("word", new ArrayList<AnimalController>((Collection<? extends AnimalController>) amRepository.findAll()));
        return "index";
    }

    @RequestMapping("/animal/{name}")
    public String getAnimal(@PathVariable String name, Model model){
        AnimalController m = amRepository.findByName(name);
        model.addAttribute("name", m.getName());
        model.addAttribute("desc", m.getDescription());
        return "animals";
    }
}
