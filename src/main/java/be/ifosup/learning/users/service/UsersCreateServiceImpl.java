package be.ifosup.learning.users.service;

import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service pour la gestion des utilisateurs
 */


/**
 *  Les services sont déclarés dans le fichier: WebSecurityConfig.java
 *  On déclare les services / utilitaires que l'on va utiliser
 *
 */
@Service
public class UsersCreateServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UsersCreateServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String username)  {

        }
    }
}
