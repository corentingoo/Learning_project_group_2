package be.ifosup.learning.users.in;

import be.ifosup.learning.constants.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserIdIn {
    public Long id;

    @NotBlank(message = "Le pseudo est obligatoire")
    public String username;

    @NotBlank(message = "Le nom de famille est obligatoire")
    public String lastname;

    @NotBlank(message = "Le prénom est obligatoire")
    public String firstname;

    @NotBlank(message = "Email obligatoire")
    public String email;

    public String role;

    public static Collection<RoleEnum> roles;

    public static Collection<RoleEnum> getRoles() {
        return roles;
    }

    public static void setRoles(Collection<RoleEnum> roles) {
        UserIdIn.roles = roles;
    }
}