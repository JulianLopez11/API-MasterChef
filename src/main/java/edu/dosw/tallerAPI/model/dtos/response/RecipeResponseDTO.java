package edu.dosw.tallerAPI.model.dtos.response;

import edu.dosw.tallerAPI.model.entity.enums.ChefType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeResponseDTO {

    @Schema(description = "Unique identifier of the recipe", example = "6713b41d4e56c9a8e2a7f1a0")
    private String id;

    @Schema(description = "Title of the recipe", example = "Spaghetti Carbonara")
    private String title;

    @Schema(description = "List of ingredients required for the recipe",
            example = "[\"Spaghetti\", \"Eggs\", \"Pancetta\", \"Parmesan Cheese\", \"Black Pepper\"]")
    private List<String> ingredients;

    @Schema(description = "Step-by-step instructions to prepare the recipe",
            example = "[\"Boil the spaghetti.\", \"Cook the pancetta.\", \"Mix eggs and cheese.\", \"Combine all ingredients.\"]")
    private List<String> steps;

    @Schema(description = "Information about the chef who created the recipe")
    private ChefResponseDTO chef;

    @Schema(description = "Type of chef who created the recipe", example = "PARTICIPANT")
    private ChefType chefType;

    @Schema(description = "Season number if the chef is a participant", example = "1")
    private Integer season;
}
