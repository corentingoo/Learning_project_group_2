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

    public void setId(Integer id) {
        this.id = id;
    }
}
