package edu.dosw.tallerAPI.model.dtos.request;

import java.util.List;

import edu.dosw.tallerAPI.model.entity.Chef;
import edu.dosw.tallerAPI.model.entity.enums.ChefType;
import jakarta.persistence.Id;
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
    private String id;
    private String title;
    private List<String> ingredients;
    private List<String> steps;
    private Chef chef;
    private ChefType chefType;
    private int season;
}
