package be.ifosup.learning.users.entities;

import be.ifosup.learning.constants.RoleEnum;
import be.ifosup.learning.utils.BCryptManagerUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Cette classe va gérer les utilisateurs de la plateforme
 */

@Entity


/**
*  @Data = pour avoir les getters et setters
*/
@Data
@Table(name = "users")


/**
 *  @BUILDER, càd qu'il permet le construction d'objets complexes
 */
@Builder

/**
 *  @NoArgsConstructor, càd qu'il génère notre constructeur sans argument et en accès public
 */
@NoArgsConstructor



/**
 *  @AllArgsConstructor,  càd qu'il génère notre constructeur avec tous les arguments sous forme de liste
 *  qui ira supplanter la liste initiale et en accès public.
 */
@AllArgsConstructor
public class User implements UserDetails {

    /**
     * En mettant:
     *  @Id = j'annote et je dis qu'est-ce qui va où
     *  Donc, j'ai juste redéclaré les colonnes.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long id;

    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @NotNull
    @Column(name = "firstname", nullable = false)
    private String firstname;

    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @Cascade(value = org.hibernate.annotations.CascadeType.REMOVE)
    @JoinTable(
            indexes = {@Index(name = "INDEX_USER_ROLE", columnList = "id_user")},
            name = "roles",
            joinColumns = @JoinColumn(name = "id_user")
    )
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Collection<RoleEnum> roles;

    @Column(name = "account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    @Column(name = "enabled")
    private boolean enabled;

    /* ajout du champ email de notre table user */
    @NotNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = StringUtils.collectionToCommaDelimitedString(getRoles().stream()
                .map(Enum::name).collect(Collectors.toList()));
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    public void setPassword(String password) {
        if(!password.isEmpty()) {
            this.password = BCryptManagerUtil.passwordEncoder().encode(password);
        }
    }
}
