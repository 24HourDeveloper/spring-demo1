package com.aandmcoding.springdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
//    private Animal animal = new Animal("Ant", "Has for legs");
//    private Animal animal2 = new Animal("Dog", "Has black long hair and great sense of smell");
    @Autowired
    private  AnimalRepository animalRepository;

    @RequestMapping("/")
    public String getWord(Model model){
        model.addAttribute("word", animalRepository.allAnimals());
        //model.addAttribute("wordd", animalRepositor);
        //model.addAttribute("animalName2", animal2.getName());
        //model.addAttribute("animalDescription2", animal2.getDescription());
        return "index";
    }

    @RequestMapping("/animal")
    public String getWords(Model model){
        //model.addAttribute("word", animal.getName());
        return "index";
    }
}
