package be.ifosup.learning.formations.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormationIn {
    @NotNull
    private String titre;
    @NotNull
    private Integer num_eleve;
    @NotNull
    private Date date_debut;
    @NotNull
    private Date date_fin;

}
