package com.aandmcoding.springdemo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private Animal[] animals = {new Animal("Ant", "Has four legs"),
            new Animal("dog", "Like to wag its tail"),
            new Animal("cat", "like to chase after mice"),
            new Animal("bird", "like to to fly"),
            new Animal("cow", "like to eat grass")};

    @RequestMapping("/{name}")
    public String getAnimal(@PathVariable String name, Model model){

        String animal = null;
        String desc = null;
        for(Animal a: animals){
            if (a.getName().equalsIgnoreCase(name)){
                animal = a.getName();
                desc = a.getDescription();
                model.addAttribute("name", name);
                model.addAttribute("desc", desc);
                return "index";
            }
        }
        return null;
    }
}
