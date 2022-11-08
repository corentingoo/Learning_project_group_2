package be.ifosup.learning.formations.entities;

import be.ifosup.learning.constants.RoleEnum;
import be.ifosup.learning.utils.BCryptManagerUtil;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Table(name = "formations")
@Data
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "titre", nullable = false, unique = true)
    private String titre;

    @NotNull
    @Column(name = "profNom", nullable = false)
    private String profNom;

    @NotNull
    @Column(name = "num_eleve")
    private Integer num_eleve;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
}
