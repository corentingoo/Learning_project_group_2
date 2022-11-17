package be.ifosup.learning.webservice.controller.admin;


import be.ifosup.learning.formations.service.FormationService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import be.ifosup.learning.formations.in.FormationIn;

import org.springframework.ui.Model;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin/formation")
public class FormationController {

    @Autowired
    private FormationService formationservice;

    // Methods for Retrieval operations
    @GetMapping()
    public String formationpage(Model model) {
        model.addAttribute("formations", formationservice.listAll());
        return "admin/formation/index";
    }

    @GetMapping("/create")
    public String formationcreatepage(Model model) {
        model.addAttribute("formations", new FormationIn());
        return "/admin/formation/create.html";
    }

    @PostMapping("/create")
    public String createFormation(@Valid @ModelAttribute("formations") FormationIn formationIn, Model model) {

        //Informations de la formation
        String formationTitre = formationIn.getTitre();
        String formationNumeleve = formationIn.getNum_eleve().toString();

        try {
            formationservice.save(formationIn);
        }

        catch(Exception e){
            return "redirect:/admin/formation/create.html";
        }

        return "redirect:/admin/formation/";
    }

    @GetMapping("/delete/{id}")
    public String deleteFormation(@PathVariable("id") Long id) {
        try {
            formationservice.delete(id);
        } catch (Exception e) {

        }

        return "redirect:/admin/formation/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") String id, Model model) {
        model.addAttribute("formations", formationservice.get(Long.valueOf(id)));


        return "/admin/formation/update";
    }

    @PostMapping("/update/{id}")
    public String updateFormation(@Valid @ModelAttribute("formations") FormationIn formationIn, @PathVariable("id") Long id , Model model) {
        try {
            formationservice.update(id , formationIn);
        }
        catch(Exception e){
            return "redirect:/admin/formation/";
        }

        return "redirect:/admin/formation/";
    }


}
