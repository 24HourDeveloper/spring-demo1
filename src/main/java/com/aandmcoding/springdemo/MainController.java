package com.aandmcoding.springdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aandmcoding.springdemo.AnimalController;

@Controller
public class MainController {
    private Animal animal = new Animal("Ant", "Has for legs");
    private Animal animal2 = new Animal("Dog", "Has black long hair and great sense of smell");

    @RequestMapping("/")
    public String getWord(Model model){
        model.addAttribute("word", animal.getName());
        model.addAttribute("wordd", animal.getDescription());
        model.addAttribute("animalName2", animal2.getName());
        model.addAttribute("animalDescription2", animal2.getDescription());
        return "index";
    }

    @RequestMapping("/animal")
    public String getWords(Model model){
        model.addAttribute("word", animal.getName());
        return "index";
    }


    /*
    code added by alfred

    this should allow you to enter a different name in the url
    and a different aniaml and description each time

     */

    @Autowired
    private AnimalRepository animalRepository;

    @RequestMapping("/{name}")
    public String getAnimal(@PathVariable String name, Model model){

        AnimalController m = animalRepository.findByName(name);
        model.addAttribute("name", m.getName());
        model.addAttribute("desc", m.getDescription());
        return "animals";

    }
}
