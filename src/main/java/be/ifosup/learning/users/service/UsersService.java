package be.ifosup.learning.users.service;


import be.ifosup.learning.users.in.UserIn;
import be.ifosup.learning.users.out.UserOut;
import java.util.List;

/**
 * Service pour la gestion des utilisateurs
 */


/**
 *  Les services sont déclarés dans le fichier: WebSecurityConfig.java
 *  On déclare les services / utilitaires que l'on va utiliser
 *
 */

public interface UsersService  {


    /* read all */
    public List<UserOut> listAll();


    /* create */
    UserOut save(UserIn userIn);



    /* update */
    UserOut update(Long id, UserIn userIn);




    /* read 1 by id */
    UserOut get(Long id);



    /* delete by id */
    public void delete(Long id);
}
