package be.ifosup.learning.types.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeIdIn {
    public Long type_id;

    @NotBlank(message = "Le titre est obligatoire")
    public String titre;

    public String description;
}
