package edu.dosw.tallerAPI.mapper;

import org.mapstruct.Mapper;

import edu.dosw.tallerAPI.model.dtos.request.RecipeRequestDTO;
import edu.dosw.tallerAPI.model.dtos.response.RecipeResponseDTO;
import edu.dosw.tallerAPI.model.entity.Recipe;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    Recipe toEntity(RecipeRequestDTO dto);
    RecipeResponseDTO toDTO(Recipe recipe);
    
}
