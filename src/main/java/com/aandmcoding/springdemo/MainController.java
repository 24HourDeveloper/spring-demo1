package com.aandmcoding.springdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private AmRepository amRepository;

    @RequestMapping("/")
    public String getWord(Model model){
        model.addAttribute("word", new ArrayList<Animal>(amRepository.findAll()));
        return "index";
    }

    @RequestMapping("/animal/{id}")
    public String getAnimal(@PathVariable String id, Model model){
        Animal m = amRepository.findByName(id);
        model.addAttribute("name", m.getId());
        model.addAttribute("desc", m.getDescription());
        return "animals";
    }

    @RequestMapping("/api/animal/{name}")
    @ResponseBody
    public Animal grabAnimal(@PathVariable String name){
        Animal m = amRepository.findByName(name);
        return m;
    }


    //This method is used to create a REST Api for the AnimalController
    @RequestMapping("/api")
    @ResponseBody
    public List<Animal> grabWord(){
        return new ArrayList<>(amRepository.findAll());
    }
}
