package be.ifosup.learning.formations.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormationIn {
    @NotNull
    private String titre;
    @NotNull
    private Integer num_eleve;
}
