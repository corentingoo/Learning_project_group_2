package be.ifosup.learning.formations.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFormationIn {
    @NotNull
    private String titre;
    @NotNull
    private Integer num_eleve;
}
