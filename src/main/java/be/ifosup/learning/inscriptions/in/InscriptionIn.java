package be.ifosup.learning.inscriptions.in;

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

public class InscriptionIn {
    @NotNull
    public Long student_id;
    @NotNull
    public Long formation_id;

}
