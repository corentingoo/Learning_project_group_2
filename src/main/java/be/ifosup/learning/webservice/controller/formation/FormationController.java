package be.ifosup.learning.webservice.controller.formation;


import be.ifosup.learning.formations.service.FormationService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

import be.ifosup.learning.formations.in.CreateFormationIn;
import be.ifosup.learning.formations.out.FormationOut;
import org.springframework.http.*;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/formation")
public class FormationController {

    @Autowired
    private FormationService formationservice;

    // Methods for Retrieval operations
    @GetMapping()
    public String formationpage(Model model) {
        model.addAttribute("formations", formationservice.listAll());
        return "formation/index";
    }


}
