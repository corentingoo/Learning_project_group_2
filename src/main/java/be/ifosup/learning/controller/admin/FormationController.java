package be.ifosup.learning.controller.admin;

import be.ifosup.learning.formations.in.FormationIdIn;
import be.ifosup.learning.formations.service.FormationService;
import be.ifosup.learning.types.service.TypeService;
import be.ifosup.learning.users.service.UserService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import be.ifosup.learning.formations.in.FormationIn;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin/formation")
public class FormationController {

    @Autowired
    private FormationService formationservice;
    @Autowired
    private UserService userservice;

    @Autowired
    private TypeService typeService;

    @GetMapping()
    public String formationpage(Model model) {
        model.addAttribute("formations", formationservice.listAll());
        model.addAttribute("profs", userservice.listAllbyRole("TEACHER"));
        return "admin/formation/index";
    }

    @GetMapping("/create")
    public String formationcreatepage(Model model) {
        model.addAttribute("formations", new FormationIn());
        model.addAttribute("profs", userservice.listAllbyRole("TEACHER"));
        model.addAttribute("types", typeService.listAll());
        return "/admin/formation/create";
    }

    @PostMapping("/create")

    public String createFormation(@Valid @ModelAttribute("formations") FormationIn formationIn, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("profs", userservice.listAllbyRole("TEACHER"));
            model.addAttribute("types", typeService.listAll());
            return "admin/formation/create.html";
        }
        try {
            formationservice.save(formationIn);
            attributes.addFlashAttribute("messagepos", "La formation a été ajoutée.");
        }
        catch(Exception e){
            attributes.addFlashAttribute("messageneg", "Impossible de créer la formation.");
            return "redirect:/admin/formation/create";
        }

        return "redirect:/admin/formation/";
    }

    @GetMapping("/delete/{id}")
    public String deleteFormation(@PathVariable("id") Long id, RedirectAttributes attributes) {
        try {
            formationservice.delete(id);
            attributes.addFlashAttribute("messagepos", "La formation a été supprimée.");
        } catch (Exception e) {
            attributes.addFlashAttribute("messageneg", "Impossible de supprimer la formation.");
        }

        return "redirect:/admin/formation/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") String id, Model model) {
        model.addAttribute("formations", formationservice.get(Long.valueOf(id)));
        model.addAttribute("profs", userservice.listAllbyRole("TEACHER"));
        model.addAttribute("types", typeService.listAll());

        return "/admin/formation/update.html";
    }

    @PostMapping("/update")
    public String updateFormation(@Valid @ModelAttribute("formations") FormationIdIn formationIdIn, BindingResult result, RedirectAttributes attributes, Model model) {
        Long id = formationIdIn.getFormation_id();;
        if (result.hasErrors()) {
            model.addAttribute("profs", userservice.listAllbyRole("TEACHER"));
            model.addAttribute("types", typeService.listAll());
            return "/admin/formation/update.html";
        }
        try {
            formationservice.update(id, formationIdIn);
            attributes.addFlashAttribute("messagepos", "La formation a été modifiée.");
        }
        catch(Exception e){
            attributes.addFlashAttribute("messageneg", "Impossible de modifier la formation.");
        }

        return "redirect:/admin/formation/";
    }

}
