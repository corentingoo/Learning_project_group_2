package be.ifosup.learning.webservice.controller.formation;


import be.ifosup.learning.formations.service.FormationService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.*;

import be.ifosup.learning.formations.in.CreateFormationIn;
import be.ifosup.learning.formations.out.FormationOut;
import org.springframework.http.*;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


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

    @GetMapping("/create")
    public String formationcreatepage(Model model) {
        model.addAttribute("formations", new CreateFormationIn());
        return "/formation/create.html";
    }

    @PostMapping("/create")
    public String createFormation(@Valid @ModelAttribute("formations") CreateFormationIn createFormationIn, Model model) {

        //Informations de la formation
        String formationTitre = createFormationIn.getTitre();
        String formationNumeleve = createFormationIn.getNum_eleve().toString();

        try {
            formationservice.save(createFormationIn);
        }

        catch(Exception e){
            return "redirect:/formation/create.html";
        }

        return "redirect:/formation/";
    }


}
