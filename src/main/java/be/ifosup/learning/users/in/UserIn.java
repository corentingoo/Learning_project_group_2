package be.ifosup.learning.users.in;

import be.ifosup.learning.constants.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

/**
 * càd dans le sens de mon Front-End vers le Back-End
 */

/**
 * Uniquement pour le rôle ADMIN
 */
public class UserIn {

    public String username;

    public String lastname;

    public String firstname;

    public String email;

    public String role;

    public static Collection<RoleEnum> roles;

    public static void addRole(RoleEnum role) {
        roles.add(role);
    }

    public static Collection<RoleEnum> getRoles() {
        return roles;
    }

    public static void setRoles(Collection<RoleEnum> roles) {
        UserIn.roles = roles;
    }
}