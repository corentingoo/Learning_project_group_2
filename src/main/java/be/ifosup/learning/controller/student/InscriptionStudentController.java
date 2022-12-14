package be.ifosup.learning.controller.student;

import be.ifosup.learning.formations.in.FormationIn;
import be.ifosup.learning.formations.service.FormationService;
import be.ifosup.learning.inscriptions.entities.Inscription;
import be.ifosup.learning.inscriptions.in.InscriptionIn;
import be.ifosup.learning.inscriptions.service.InscriptionService;
import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/student/formation")
public class InscriptionStudentController {
    @Autowired
    private InscriptionService inscriptionservice;
    @Autowired
    private FormationService formationservice;
    @Autowired
    private UserService userservice;

    public InscriptionStudentController(InscriptionService inscriptionservice, FormationService formationService, UserService userservice) {
        this.inscriptionservice = inscriptionservice;
        this.formationservice = formationService;
        this.userservice = userservice;
    }

    @GetMapping()
    public String formationstudentpage(Model model) {
        model.addAttribute("formations", formationservice.listAll());
        return "student/formation/index";
    }

    @GetMapping("/inscription")
    public String inscriptionformationstudentpage(Model model) {
        User user = userservice.getCurrentUser();
        Long id = user.getId();

        model.addAttribute("formations", inscriptionservice.findAllByStudentId(id));
        model.addAttribute("user", userservice.getCurrentUser().getId());
        return "student/formation/inscription";
    }
    @GetMapping("/create/{id}")
    public String inscriptioncreatepage(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        model.addAttribute("inscriptions", new InscriptionIn());
        model.addAttribute("users", userservice.getCurrentUser());
        model.addAttribute("formations", formationservice.get(id));
        if (inscriptionservice.inscriptionExist(userservice.getCurrentUser().getId(),id)) {
            attributes.addFlashAttribute("messageneg", "Vous êtes déjà inscris à cette formation");
            return "redirect:/student/formation/";
        }
        return "student/formation/create";
    }

    @PostMapping("/create")
    public String createFormation(@Valid @ModelAttribute("inscriptions") InscriptionIn inscriptionIn, RedirectAttributes attributes) {
        try {
            inscriptionservice.save(inscriptionIn);
            attributes.addFlashAttribute("messagepos", "Votre inscription a bien été ajoutée");
        }
        catch(Exception e){
            attributes.addFlashAttribute("messageneg", "Impossible de vous inscrire à cette formation");
        }
        return "redirect:/student/formation/";
    }


}
