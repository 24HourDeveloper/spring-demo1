package com.aandmcoding.springdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private  AnimalRepository animalRepository;

    @RequestMapping("/")
    public String getWord(Model model){
        model.addAttribute("word", animalRepository.allAnimals());
        return "index";
    }

    @RequestMapping("/animal/{name}")
    public String getAnimal(@PathVariable String name, Model model){
        Animal animal = animalRepository.getAnimal(name);
        model.addAttribute("name", animal.getName());
        model.addAttribute("desc", animal.getDescription());
        return "animals";

    }

    /*
    ***code added by alfred***
    this should allow you to enter a different name in the url
    and get a different animal and description each time
     */
    //@Autowired
    //private AmRepository amRepository;

//    @RequestMapping("/{name}")
//    public String getAnimal(@PathVariable String name, Model model){
//        AnimalController m = amRepository.findByName(name);
//        model.addAttribute("name", m.getName());
//        model.addAttribute("desc", m.getDescription());
//        return "animals";
//
//    }
}
