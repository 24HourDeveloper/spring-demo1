package com.aandmcoding.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Paths;
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
        model.addAttribute("word", new ArrayList<Animal>((Collection<? extends Animal>) amRepository.findAll()));
        return "index";
    }

    @RequestMapping(value = "/animal/{name}", method = RequestMethod.GET)
    public String getAnimal(@PathVariable String name, Model model){
        Animal m = amRepository.findByName(name);
        model.addAttribute("name", m.getName());
        model.addAttribute("desc", m.getDescription());
        model.addAttribute("img", m.getImage());
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

        try{
            //debug statements
            File path1 = new File("");
            System.out.println("$$$$$$$$$$$$$$$ " + path1.getAbsolutePath() + " $$$$$$$$$$$$$$$");
            String path2 = "\\src\\main\\resources\\static\\";
            String path3 = path1.getAbsolutePath() + path2;
            System.out.println("$$$$$$$$$$$$$ " + path3 + " $$$$$$$$$$$$$");
            String filename = image.getOriginalFilename();
            String directory = "/img";
            String filepath = Paths.get(directory, filename).toString();
            System.out.println("$$$$$$$$$$$$$ " + filepath + " $$$$$$$$$$$$$");
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path3 + filepath)));
            stream.write(image.getBytes());
            stream.close();
            Animal newAnimal = new Animal(name, description, "/img/" + filename);
            amRepository.save(newAnimal);
        }catch(Exception e){
            e.printStackTrace();
        }
        //BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\A\\githubproj\\spring-demo1\\src\\main\\resources\\static" + filepath)));
//        String path = "/img/" + image.toString();
//        File file = new File("C:\\Users\\A\\githubproj\\spring-demo1\\src\\main\\resources\\static\\img\\" + image.toString());
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Animal newAnimal = new Animal(name, description, path);
//        amRepository.save(newAnimal);
        return "admin-page";
    }
}
