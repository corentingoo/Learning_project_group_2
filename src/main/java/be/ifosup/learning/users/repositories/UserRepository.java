package be.ifosup.learning.users.repositories;

import be.ifosup.learning.constants.RoleEnum;
import be.ifosup.learning.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
    @Query("SELECT u FROM User u LEFT JOIN Role r on u.id = r.id_user WHERE r.role = :role")
    List<User> allUserByRole(@Param("role")String role);












}
