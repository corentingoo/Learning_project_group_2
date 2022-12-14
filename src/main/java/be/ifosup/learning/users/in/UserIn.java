package be.ifosup.learning.users.in;

import be.ifosup.learning.constants.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

    @NotBlank(message = "Le pseudo est obligatoire")
    public String username;

    @NotBlank(message = "Le nom de famille est obligatoire")
    public String lastname;

    @NotBlank(message = "Le prénom est obligatoire")
    public String firstname;

    @NotBlank(message = "Email obligatoire")
    @Email
    public String email;

    @NotBlank(message = "Le role est obligatoire")
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