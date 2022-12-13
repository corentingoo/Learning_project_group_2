package be.ifosup.learning.inscriptions.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class InscriptionIn {
    @NotBlank(message = "L'étudiant' est obligatoire")
    public Long student_id;
    @NotBlank(message = "La formation est obligatoire")
    public Long formation_id;

}
