package be.ifosup.learning.types.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeOut {
    public Long type_id;
    public String titre;
    public String description;
}
