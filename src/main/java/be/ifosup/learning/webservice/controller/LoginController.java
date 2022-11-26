package be.ifosup.learning.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* Controller pour la page admin
* */
@Controller
/** @RequestMapping renvoit un array de string
 * */
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String loginPage() {
        return "login";
    }
}