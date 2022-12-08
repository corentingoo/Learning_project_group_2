package be.ifosup.learning.webservice.controller.admin;


import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.in.UserIn;
import be.ifosup.learning.users.out.UserOut;
import be.ifosup.learning.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;



@Controller
@RequestMapping("/admin/users")
public class UserController {

    /** Le controller est lié au service (qui est une interface, sorte de boîte à outils) */
    @Autowired
    private UsersService usersService;

    /**
     *  read
     */
    @GetMapping()
    public String list(Model model){
        model.addAttribute("users",usersService.listAll());
        return "admin/users/index";
    }



    /** create */
    @GetMapping("/create")
    public String userCreatePage(Model model){
        model.addAttribute("users", new User());
        return "admin/users/create.html";
    }





    /** create - 2e étape post */
    @PostMapping("/create")
    public String createuser(@Valid @ModelAttribute("users") UserIn userIn, Model model){

        String userNom = userIn.getLastname();
        String userPrenom = userIn.getFirstname();
        String userEmail = userIn.getEmail();
        String userNomdutilisateur = userIn.getUsername();


        try {
            /* Verification que les champs requis sont soumis sans etre vide */
            if (    !userNom.isEmpty() && userNom != null &&
                    !userPrenom.isEmpty() && userPrenom != null &&
                    !userEmail.isEmpty() && userEmail != null &&
                    !userNomdutilisateur.isEmpty() && userNomdutilisateur != null){

                /* Pour debug: voir le contenu ramené par mon post */
//                System.out.println(userNom + " " + userPrenom + " " + userEmail + " " + userNomdutilisateur);
                usersService.save(userIn);
            }
        }

        catch (Exception e){
            return "redirect:/admin/users/create.html";
        }

        /* Retour à la page des vues des utilisateurs */
        return "redirect:/admin/users/";
    }



    /** Update Partie 1 */
    @GetMapping("/update/{id}")
    public String updateFirststep(@PathVariable("id") String id, Model model){
        model.addAttribute("users", usersService.get(Long.valueOf(id)));
        return  "/admin/users/update";
    }


    /** Update Partie 2 */
    @PostMapping("/update/{id}")
    public String updateUser(@Valid @ModelAttribute("users") UserIn userIn, @PathVariable("id") Long id, Model model){


        String userNom = userIn.getLastname();
        String userPrenom = userIn.getFirstname();
        String userEmail = userIn.getEmail();
        String userNomdutilisateur = userIn.getUsername();


        try{
//            System.out.println(userNom + " " + userPrenom + " " + userEmail + " " + userNomdutilisateur);

            /** Ceci va vers mon update( ) de mon userOut, càd vers ma db */
            usersService.update(id, userIn);
        } catch (Exception e){
            return  "redirect:/admin/users/";
        }
        return  "redirect:/admin/users/";
    }



    /** Delete */
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        try{
            usersService.delete(id);
        } catch (Exception e){

        }
         return  "redirect:/admin/users/";
    }
}





//    /** update */
//    @PutMapping("/users/{id}")
//    public ResponseEntity<?> update(@RequestBody UserIn user, @PathVariable Long id){
//        try{
//            UserOut existUser = usersService.get(id);
//            usersService.save(user);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NoSuchElementException e){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

