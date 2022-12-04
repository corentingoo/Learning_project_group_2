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
                System.out.println(userNom + " " + userPrenom + " " + userEmail + " " + userNomdutilisateur);
                usersService.save(userIn);
            }
        }

        catch (Exception e){
            return "redirect:/admin/users/create.html";
        }

        /* Retour à la page des vues des utilisateurs */
        return "redirect:/admin/users/";

    }

}




//
//    /** read by id */
//    @GetMapping("/users/{id}")
//    /** @PathVariable càd récupère une valeur dans le chemin de la ressource. */
//    public ResponseEntity<User> get(@PathVariable Long id){
//        try{
//            UserOut user = usersService.get(id);
//            return new ResponseEntity<User>((MultiValueMap<String, String>) user, HttpStatus.OK);
//        } catch (NoSuchElementException e){
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//
//    /** create */
//    @PostMapping("/users")
//    public void add(@RequestBody UserIn user){
//        usersService.save(user);
//    }
//
//
//
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
//
//
//
//    /** delete */
//    @DeleteMapping("/users/{id}")
//    public void delete(@PathVariable Long id){
//        usersService.delete(id);
//    }

