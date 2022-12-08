package be.ifosup.learning.users.repositories;

import be.ifosup.learning.constants.RoleEnum;
import be.ifosup.learning.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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


    Optional<User> findById(Long aLong);

    User findByEmail(String email);

    @Modifying
    @Query("update User u set u.token=?1 where u.id=?2")
    int updateToken(String token, Long id);

    User findByToken(String token);

    @Modifying
    @Query("update User u set u.password=?2 where u.id=?1")
    int updatePassword(Long id, String password);

    User getById(Long id);

    @Modifying
    @Query("update User u set u.username=?1 , u.firstname=?2 , u.lastname=?3, u.email=?4 where u.id =?5")
    int updateUser(String username, String firstname, String lastname, String email, Long id);

}
