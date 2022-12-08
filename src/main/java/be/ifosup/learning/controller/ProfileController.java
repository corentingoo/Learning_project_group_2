package be.ifosup.learning.controller;

import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
