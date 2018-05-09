package com.aandmcoding.springdemo;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private AmRepository amRepository;

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping("/")
    public String getWord(Model model){
        List<Animal> animalList = new ArrayList<>();
        for (Animal a: amRepository.findAll()){
            Base64 base = new Base64();
            byte[] encodeBase64 = base.encode(a.getImage());
            String base64Encoded = null;
            try {
                base64Encoded = new String(encodeBase64, "UTF-8");
                a.setDescription(base64Encoded);
                animalList.add(a);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("word", animalList);
        return "index";
    }

    @RequestMapping(value = "/animal/{name}", method = RequestMethod.GET)
    public String getAnimal(@PathVariable String name, Model model){
        Animal m = amRepository.findByName(name);
        model.addAttribute("name", m.getName());
        model.addAttribute("desc", m.getDescription());
        Base64 base = new Base64();
        byte[] encodeBase64 = base.encode(m.getImage());
        String base64Encoded = null;
        try {
            base64Encoded = new String(encodeBase64, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        model.addAttribute("img", base64Encoded );
        return "animals";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String showAdminLoginPage(){
        return "admin-login";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String adminLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        Users user;
        if ( usersRepository.findByUsername(username) != null){
            user = usersRepository.findByUsername(username);
            if (user.getPassword().equals(password)){
                return "admin-page";
            }
        }
        return "admin-login";
    }

    @RequestMapping("/edit-page")
    public String editAnimals(Model model){
        model.addAttribute("animals", new ArrayList<Animal>((Collection<? extends Animal>) amRepository.findAll()));
        return "edit-page";
    }

    @RequestMapping(value="/edit-page", method = RequestMethod.PATCH)
    public String saveEditAnimals(@ModelAttribute("things") List<Animal> a){
        amRepository.saveAll(a);
        return "admin-page";
    }

    @RequestMapping(value = "/admin-page")
    public String showAdminPage(){
        return "admin-page";
    }

    @RequestMapping(value = "/add-new", method = RequestMethod.GET)
    public String showAddAnimalPage(){
        return "add-new";
    }

    @RequestMapping(value = "/add-new" , method = RequestMethod.POST)
    public String addNewAnimal(@RequestParam("name")String name, @RequestParam("description")String description, @RequestParam("image")MultipartFile image){
        try {
            byte[] pic = image.getBytes();
            Animal newAnimal = new Animal(name, description, pic);
            amRepository.save(newAnimal);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "admin-page";
    }
}
