package be.ifosup.learning.users.out;

import be.ifosup.learning.constants.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * càd dans le sens de mon Back-End vers mon Front-End
 */

/**
 * Uniquement pour le rôle ADMIN
 */
public class UserOut {
    private Long id;


    private String username;

    private String lastname;

    private String firstname;

    private Collection<RoleEnum> roles;


}