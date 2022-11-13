package be.ifosup.learning.users.in;

import be.ifosup.learning.constants.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor

/**
 * càd dans le sens de mon Front-End vers le Back-End
 */

/**
 * Uniquement pour le rôle ADMIN
 */
public class UserIn {
    @NotNull
    private String username;

    @NotNull
    private String lastname;

    @NotNull
    private String firstname;

    private Collection<RoleEnum> roles;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @NotNull
    private String email;
}
