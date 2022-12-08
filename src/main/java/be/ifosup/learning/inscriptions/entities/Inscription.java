package be.ifosup.learning.inscriptions.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "inscriptions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inscription_id")
    private Long inscription_id;

    @NotNull
    @Column(name = "student_id", nullable = false)
    private Long student_id;

    @NotNull
    @Column(name = "formation_id", nullable = false)
    private Long formation_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getInscription_id() {
        return inscription_id;
    }
    public Long getStudent_id() {
        return student_id;
    }
    public Long getFormation_id() {
        return formation_id;
    }

    public void setInscription_id(Long inscription_id) {
        this.inscription_id = inscription_id;
    }
}

