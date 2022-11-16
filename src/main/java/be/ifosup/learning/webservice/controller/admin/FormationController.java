package be.ifosup.learning.webservice.controller.admin;


import be.ifosup.learning.formations.service.FormationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.*;

import be.ifosup.learning.formations.in.CreateFormationIn;
import be.ifosup.learning.formations.out.FormationOut;
import org.springframework.http.*;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("formations", new CreateFormationIn());
        return "/admin/formation/create.html";
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

    @PatchMapping("/update")
    public String updateFormation(@Valid @ModelAttribute("reservations") CreateFormationIn formationIn, @PathVariable Long id, Model model) {
        try {
            formationservice.update(id, formationIn);
        }
        catch(Exception e){
            return "redirect:/admin/formation/";
        }

        return "redirect:/admin/formation/";
    }


}
