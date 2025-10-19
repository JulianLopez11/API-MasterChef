package edu.dosw.tallerAPI.model.dtos.response;

import edu.dosw.tallerAPI.model.entity.enums.ChefType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChefResponseDTO {

    @Schema(description = "name of the chefs", example = "Jorge Raush")
    private String name;
    
    private ChefType type;
    
}
