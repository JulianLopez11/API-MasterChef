package edu.dosw.tallerAPI.model.dtos.response;

import edu.dosw.tallerAPI.model.entity.Chef;
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

    @Schema(description = "Unique identifier of the recipe", example = "01")
    private String id;

    @Schema(description = "Title of the recipe", example = "Spaghetti Carbonara")
    private String title;

    @Schema(description = "List of ingredients required for the recipe",
            example = "[\"Spaghetti\", \"Eggs\", \"Pancetta\", \"Parmesan Cheese\", \"Black Pepper\"]")
    private List<String> ingredients;

    @Schema(description = "Step-by-step instructions to prepare the recipe",
            example = "[\"COOK THE MEAT.\", \"CUT THE VEGETABLES.\", \"MIX EVERYTHING.\"]")
    private List<String> steps;

    @Schema(description = "Information about the chef who created the recipe")
    private Chef chef;

    @Schema(description = "Season number if the chef is a participant", example = "1")
    private Integer season;
}
