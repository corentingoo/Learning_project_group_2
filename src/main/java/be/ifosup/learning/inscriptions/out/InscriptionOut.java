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
    public Long student_id;
    public Long formation_id;
}