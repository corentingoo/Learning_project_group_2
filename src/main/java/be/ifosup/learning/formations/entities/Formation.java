package be.ifosup.learning.formations.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "formations")
@Data
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "formation_id")
    private Long formation_id;

    @NotNull
    @Column(name = "titre", nullable = false)
    private String titre;

    @NotNull
    @Column(name = "prof_nom", nullable = false)
    private String prof_nom;

    @NotNull
    @Column(name = "num_eleve")
    private Integer num_eleve;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getFormation_id() {
        return formation_id;
    }

    public void setFormation_id(Long formation_id) {
        this.formation_id = formation_id;
    }
}
