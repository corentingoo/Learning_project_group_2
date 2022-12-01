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
    public String username;

    @NotNull
    public String lastname;

    @NotNull
    public String firstname;

    public Collection<RoleEnum> roles;


}