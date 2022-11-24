package be.ifosup.learning.webservice.controller.admin;


import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.in.UserIn;
import be.ifosup.learning.users.out.UserOut;
import be.ifosup.learning.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


/** Pour indiquer à Spring que nous sommes en API RESTful
 *  avec communication en JSON */
@Controller
@RequestMapping("/admin/users")
public class UserController {

    /** Le controller est lié au service (qui est une interface, sorte de boîte à outils) */
    @Autowired
    private UsersService usersService;

    /**
     * API read
     */
    @GetMapping("/users")
    public List<UserOut> list(){
        return usersService.listAll();
    }

    /** API read by id */
    @GetMapping("/users/{id}")
    /** @PathVariable càd récupère une valeur dans le chemin de la ressource. */
    public ResponseEntity<User> get(@PathVariable Long id){
        try{
            UserOut user = usersService.get(id);
            return new ResponseEntity<User>((MultiValueMap<String, String>) user, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }


    /** API create */
    @PostMapping("/users")
    public void add(@RequestBody UserIn user){
        usersService.save(user);
    }

    /** API update */
    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(@RequestBody UserIn user, @PathVariable Long id){
        try{
            UserOut existUser = usersService.get(id);
            usersService.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    /** API delete */
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id){
        usersService.delete(id);
    }
}
