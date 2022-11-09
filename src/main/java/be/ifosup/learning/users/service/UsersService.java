package be.ifosup.learning.users.service;


import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Service pour la gestion des utilisateurs
 */


/**
 *  Les services sont déclarés dans le fichier: WebSecurityConfig.java
 *  On déclare les services / utilitaires que l'on va utiliser
 *
 */
@Service
@Transactional
public class UsersService  {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll(){
        return userRepository.findAll();
    }


    public void save(User creation){
        userRepository.save(creation);
    }

    public User get(Long id){
        return userRepository.findById(id).get();
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }


}
