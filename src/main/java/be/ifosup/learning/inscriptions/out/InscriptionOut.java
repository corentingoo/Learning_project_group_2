package be.ifosup.learning.inscriptions.out;

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
public class InscriptionOut {
    public Long inscription_id;
    public String username;
    public String titre;
    public String date_debut;
    public String date_fin;
}