package edu.dosw.tallerAPI.model.dtos.request;

import java.util.List;

import edu.dosw.tallerAPI.model.entity.Chef;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeRequestDTO {
    @Id
    @Schema(description = "Identifier Of Chefs", example = "1")
    @NotNull(message = "The id cannot be null")
    private String id;

    @Schema(description = "Title of the recipe", example = "Spaghetti Pesto")
    private String title;

    @Schema(description = "List of ingredients required for the recipe",
            example = "[\"Spaghetti\", \"Basil\", \"Pine Nuts\", \"Parmesan Cheese\", \"Olive Oil\"]")
    private List<String> ingredients;

    @Schema(description = "Step-by-step instructions to prepare the recipe",
            example = "[\"Boil the spaghetti.\", \"IDK how to make pesto, maybe mix a lot of herbs.\"]")
    private List<String> steps;

    @Schema(description = "Information about the chef who created the recipe")
    private Chef chef;


    @Schema(description = "Season number if the chef is a participant", example = "1")
    private int season;
}
