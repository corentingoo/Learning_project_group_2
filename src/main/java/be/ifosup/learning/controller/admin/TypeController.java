package be.ifosup.learning.controller.admin;

import be.ifosup.learning.types.in.TypeIdIn;
import be.ifosup.learning.types.in.TypeIn;
import be.ifosup.learning.types.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/type")
public class TypeController {

    @Autowired
    private TypeService typeservice;

    @GetMapping()
    public String typepage(Model model) {
        model.addAttribute("types", typeservice.listAll());
        return "admin/type/index";
    }

    @GetMapping("/create")
    public String typecreatepage(Model model) {
        model.addAttribute("types", new TypeIn());
        return "/admin/type/create.html";
    }

    @PostMapping("/create")
    public String createType(@Valid @ModelAttribute("types") TypeIn typeIn, BindingResult result, RedirectAttributes attributes ) {
        if (result.hasErrors()) {
            return "/admin/type/create.html";
        }

        try {
            typeservice.save(typeIn);
            attributes.addFlashAttribute("messagepos", "La matière a été ajoutée.");
        }
        catch(Exception e){
            attributes.addFlashAttribute("messageneg", "Impossible dé créer une nouvelle matière.");
            return "redirect:/admin/type/";
        }

        return "redirect:/admin/type/";
    }

    @GetMapping("/delete/{id}")
    public String deleteType(@PathVariable("id") Long id, RedirectAttributes attributes) {
        try {
            typeservice.delete(id);
            attributes.addFlashAttribute("messagepos", "La matière a été supprimée.");
        } catch (Exception e) {
            attributes.addFlashAttribute("messageneg", "Impossible dé supprimer une matière.");
        }
        return "redirect:/admin/type/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") String id, Model model) {
        model.addAttribute("types", typeservice.get(Long.valueOf(id)));

        return "/admin/type/update";
    }

    @PostMapping("/update/{id}")
    public String updateFormation(@Valid @ModelAttribute("types") TypeIdIn typeIdIn, BindingResult result, @PathVariable("id") Long id, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "/admin/type/update.html";
        }
        try {
            typeservice.update(id, typeIdIn);
            attributes.addFlashAttribute("messagepos", "La matière a été modifiée.");
        }
        catch(Exception e){
            attributes.addFlashAttribute("messageneg", "Impossible de modifier la matière.");
            return "redirect:/admin/type/";
        }

        return "redirect:/admin/type/";
    }
}
