package be.ifosup.learning.controller;

import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.in.UserIn;
import be.ifosup.learning.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private UserService userservice;

    @GetMapping()
    public String profilepage(Model model) {
        User user = userservice.getCurrentUser();
        Long id = user.getId();

        model.addAttribute("users", userservice.get(Long.valueOf(id)));
        return "public/profile.html";
    }

    @PostMapping("/update/{id}")
    public String updateFormation(@Valid @ModelAttribute("users") UserIn userIn, @PathVariable("id") Long id , Model model) {
        try {
            userservice.update(id, userIn);
        }
        catch(Exception e){
        }
        model.addAttribute("users", userservice.get(Long.valueOf(id)));
        return "public/profile.html";
    }

    @PostMapping("/updatepassword/{id}")
    public String updatePass(@RequestParam("password") String password, Model model) {
        User user = userservice.getCurrentUser();
        Long id = user.getId();
        //verification mot de passe DB
        //verification mot de passe match
        try {
            userservice.updatePassword(id, password);
        }
        catch(Exception e){
            System.out.print(e);
        }
        model.addAttribute("users", userservice.get(Long.valueOf(id)));
        return "public/profile.html";
    }
}
