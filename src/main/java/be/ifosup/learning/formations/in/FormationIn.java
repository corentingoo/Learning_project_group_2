package be.ifosup.learning.formations.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormationIn {
    @NotBlank(message = "Le titre est obligatoire")
    public String titre;
    @NotNull(message = "Le nombre maximum d'élèves est obligatoire")
    @Min(value = 1, message= "Au moins une personne doit suivre la formation")
    public Integer num_eleve;
    public Date date_debut;
    public Date date_fin;
    public Long teacher;
    private Long type;
}
