package be.ifosup.learning.formations.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormationOut {
    private Long formation_id;
    private String titre;
    private Integer num_eleve;
}
