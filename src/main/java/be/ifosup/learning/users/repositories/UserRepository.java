package be.ifosup.learning.users.repositories;

import be.ifosup.learning.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gestion JPA pour les utilisateurs
 */


/**
 *  @Repository pour remettre dans son contexte et dire a Spring qu'il s'agit d'un repo
 */
@Repository
/**
 * JpaRepository<User, Long> = j'étends jpa repository qui prend 2 arguments (çad l'objet User et l'Id Long)
 * Rmq: Il a besoin de savoir quel est le format de l'Id. Par ex: Si l'id est un string ou un integer ...
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Définit une fonction qui permet de récupérer un utilisateur sur base du username
     * @param username
     * @return
     */
    User findByUsername(String username);
}
