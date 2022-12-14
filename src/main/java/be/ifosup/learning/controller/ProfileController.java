package be.ifosup.learning.controller;

import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.in.UserIdIn;
import be.ifosup.learning.users.service.UserService;
import be.ifosup.learning.utils.PasswordValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    @PostMapping("/update")
    public String updateProfile(@Valid @ModelAttribute("users") UserIdIn userIdIn, BindingResult result, Model model, RedirectAttributes attributes) {
        User user = userservice.getCurrentUser();
        String oldusername = user.getUsername();
        String newusername = userIdIn.getUsername();

        if (result.hasErrors()) {
            attributes.addFlashAttribute("messageneg", "Tous les champs doivent être remplis");
            return "redirect:/profile";
        } else if (!oldusername.equals(newusername)) {
             if (userservice.usernamexist(userIdIn.getUsername())) {
                attributes.addFlashAttribute("messageneg", "le nom d'utilisateur existe déjà");
                return "redirect:/profile";

            }

        }
        try {
            userservice.update(userIdIn.getId(), userIdIn);
            attributes.addFlashAttribute("messagepos", "Vos informations de profile ont bien été changé");
        }
        catch(Exception e){
            System.out.print(e);
            attributes.addFlashAttribute("messageneg", "Erreur pour changer vos informations de profile");
        }

        Long id = user.getId();
        model.addAttribute("users", userservice.get(Long.valueOf(id)));

        return "redirect:/profile";
    }

    @PostMapping("/updatepassword")
    public String updatePass(@RequestParam("password") String password, @RequestParam("newpassword") String newpassword, @RequestParam("renewpassword") String renewpassword, Model model, RedirectAttributes attributes) {
        User user = userservice.getCurrentUser();
        Long id = user.getId();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


        if(password.isEmpty() || newpassword.isEmpty() || renewpassword.isEmpty()) {
            attributes.addFlashAttribute("messageneg", "Tous les champs doivent être remplis");
            return "redirect:/profile";
        } else if (!passwordEncoder.matches(password, user.getPassword())) {
            attributes.addFlashAttribute("messageneg", "Le mot de passe actuel est incorrect");
            return "redirect:/profile";
        } else if (!newpassword.equals(renewpassword)) {
            attributes.addFlashAttribute("messageneg", "Le nouveau mot de passe et celui de confirmation ne correspondent pas");
            return "redirect:/profile";
        } else if (!PasswordValidation.main(newpassword)) {
            attributes.addFlashAttribute("messageneg", "Le mot de passe doit contenir au moins 1 majuscule, 1 miniscule, 1 chiffre et 1 caractère spécial");
            return "redirect:/profile";
        }
        try {
            userservice.updatePassword(id, newpassword);
            attributes.addFlashAttribute("messageneg", "Votre mot de passe a bien été modifiée");
        }
        catch(Exception e){

        }
        model.addAttribute("users", userservice.get(Long.valueOf(id)));
        return "redirect:/profile";
    }
}
