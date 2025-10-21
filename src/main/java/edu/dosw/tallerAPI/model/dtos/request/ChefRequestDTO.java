package edu.dosw.tallerAPI.model.dtos.request;

import org.bson.types.ObjectId;

import edu.dosw.tallerAPI.model.entity.enums.ChefType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ChefRequestDTO {
    
    @Schema(description = "Identifier Of Chefs", example = "1")
    @NotNull(message = "The id cannot be null")
    private String id;

    @Schema(description = "name of the chefs", example = "Jorge Raush")
    private String name;
    
    @Schema(description = "Type of chef who created the recipe", example = "COMPETITOR")
    private ChefType type;
    
}