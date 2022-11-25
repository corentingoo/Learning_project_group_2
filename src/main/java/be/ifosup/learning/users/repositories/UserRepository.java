package be.ifosup.learning.users.repositories;

import be.ifosup.learning.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

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

    @Modifying
    @Transactional
    @Query("SELECT username FROM users LEFT JOIN roles on users.id_user = roles.id_user WHERE role = ?1")
    List<User> allUserByRole(String role);




}
