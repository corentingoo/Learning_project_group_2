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
    @Column(name = "prof_id")
    private Long prof_id;

    @NotNull
    @Column(name = "titre", nullable = false, unique = true)
    private String titre;

    @NotNull
    @Column(name = "prof_nom", nullable = false)
    private String prof_nom;

    @NotNull
    @Column(name = "num_eleve")
    private Integer num_eleve;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getProf_id() {
        return prof_id;
    }

    public void setProf_id(Long prof_id) {
        this.prof_id = prof_id;
    }
}
