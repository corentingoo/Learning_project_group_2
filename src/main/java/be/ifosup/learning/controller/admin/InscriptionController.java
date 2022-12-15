package be.ifosup.learning.controller.admin;


import be.ifosup.learning.formations.repositories.FormationRepository;
import be.ifosup.learning.formations.service.FormationService;
import be.ifosup.learning.inscriptions.in.InscriptionIn;
import be.ifosup.learning.inscriptions.repositories.InscriptionRepository;
import be.ifosup.learning.inscriptions.service.InscriptionService;
import be.ifosup.learning.users.repositories.UserRepository;
import be.ifosup.learning.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin/inscription")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionservice;
    @Autowired
    private UserService userservice;

    @Autowired
    private FormationService formationservice;

    @Autowired
    public InscriptionController(InscriptionRepository inscriptionRepository, UserRepository userRepository, FormationRepository formationRepository) {

    }

    // Methods for Retrieval operations
    @GetMapping()
    public String inscriptionpage(Model model) {
        model.addAttribute("inscriptions", inscriptionservice.listAll());
        return "student/inscription/index";
    }

    @GetMapping("/create")
    public String inscriptioncreatepage(Model model) {
        model.addAttribute("inscriptions", new InscriptionIn());
        model.addAttribute("eleves", userservice.listAllbyRole("STUDENT"));
        model.addAttribute("formations", formationservice.listAll());
        return "/student/inscription/create.html";
    }

    @PostMapping("/create")
    public String createInscription(@Valid @ModelAttribute("inscriptions") InscriptionIn inscriptionIn, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "/admin/type/update.html";
        }
        try {
            inscriptionservice.save(inscriptionIn);
            attributes.addFlashAttribute("messagepos", "L'inscription a été ajoutée.");
        }
        catch(Exception e){
            attributes.addFlashAttribute("messageneg", "Impossible de créer l'inscription");
            return "redirect:/student/inscription/create.html";
        }

        return "redirect:/student/inscription/";
    }

    @GetMapping("/delete/{id}")
    public String deleteInscription(@PathVariable("id") Long id, RedirectAttributes attributes) {
        try {
            inscriptionservice.delete(id);
            attributes.addFlashAttribute("messagepos", "L'inscription a été supprimée.");
        } catch (Exception e) {
            attributes.addFlashAttribute("messageneg", "Erreur à la suppression de cette inscription");
        }

        return "redirect:/student/inscription/";
    }



}
