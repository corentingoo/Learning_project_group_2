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
    public String titre;
    @NotNull
    public Integer num_eleve;
    @NotNull
    public Date date_debut;
    @NotNull
    public Date date_fin;
    @NotNull
    public Long teacher;
}
