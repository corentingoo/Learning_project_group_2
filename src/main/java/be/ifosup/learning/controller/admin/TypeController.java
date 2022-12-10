package be.ifosup.learning.controller.admin;

import be.ifosup.learning.types.in.TypeIn;
import be.ifosup.learning.types.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("types", typeservice.listAll());
        return "/admin/type/create.html";
    }

    @PostMapping("/create")
    public String createType(@Valid @ModelAttribute("types") TypeIn typeIn, Model model) {

        try {
            typeservice.save(typeIn);
        }

        catch(Exception e){
            return "redirect:/admin/type/create.html";
        }

        return "redirect:/admin/type/";
    }

    @GetMapping("/delete/{id}")
    public String deleteType(@PathVariable("id") Long id) {
        try {
            typeservice.delete(id);
        } catch (Exception e) {

        }

        return "redirect:/admin/type/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") String id, Model model) {
        model.addAttribute("types", typeservice.get(Long.valueOf(id)));

        return "/admin/type/update";
    }

    @PostMapping("/update/{id}")
    public String updateFormation(@Valid @ModelAttribute("ftypes") TypeIn typeIn, @PathVariable("id") Long id , Model model) {
        try {
            typeservice.update(id, typeIn);

        }
        catch(Exception e){
            return "redirect:/admin/type/";
        }

        return "redirect:/admin/type/";
    }
}
