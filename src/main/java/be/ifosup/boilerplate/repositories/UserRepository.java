package be.ifosup.boilerplate.repositories;

import be.ifosup.boilerplate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gestion JPA pour les utilisateurs
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Définit une fonction qui permet de récupérer un utilisateur sur base du username
     * @param username
     * @return
     */
    User findByUsername(String username);
}
