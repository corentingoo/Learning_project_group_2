package be.ifosup.learning.users.service;


import be.ifosup.learning.users.in.UserIn;
import be.ifosup.learning.users.out.UserOut;
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
public interface UsersService  {


    /* read all */
    public List<UserOut> listAll();


    /* create */
    UserOut save(UserIn creationIn);



    /* update */
    UserOut update(Long id, UserIn creationIn);




    /* read 1 by id */
    UserOut get(Long id);



    /* delete by id */
    public void delete(Long id);
}
