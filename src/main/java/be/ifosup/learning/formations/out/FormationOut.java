package be.ifosup.learning.formations.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormationOut {
    public Long formation_id;
    public String titre;
    public Integer num_eleve;
    public Date date_debut;
    public Date date_fin;
    public Long teacher;
}
