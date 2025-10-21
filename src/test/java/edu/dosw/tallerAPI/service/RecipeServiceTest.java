package edu.dosw.tallerAPI.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.dosw.tallerAPI.mapper.RecipeMapper;
import edu.dosw.tallerAPI.model.entity.Chef;
import edu.dosw.tallerAPI.model.dtos.request.RecipeRequestDTO;
import edu.dosw.tallerAPI.model.dtos.response.RecipeResponseDTO;
import edu.dosw.tallerAPI.model.entity.Recipe;
import edu.dosw.tallerAPI.model.entity.enums.ChefType;
import edu.dosw.tallerAPI.repository.RecipeRepository;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {
    @Mock
    private RecipeRepository recipeRepository;

    @Mock
    private RecipeMapper recipeMapper;

    @InjectMocks
    private RecipeService recipeService;
    
    @Test
    void shouldCreateRecipe(){
    Chef chefRequest = Chef.builder()
    .id("1")
    .name("Nico")
    .type(ChefType.JURY)
    .build();

    RecipeRequestDTO request = RecipeRequestDTO.builder()
    .id("1")
    .title("Pasta")
    .ingredients(List.of("Flour", "Eggs", "Salt"))
    .steps(List.of("Boil water", "Cook pasta","Add sauce"))
    .chef(chefRequest)
    .chefType(ChefType.COMPETITOR)
    .build();

    Recipe recipeEntity = Recipe.builder()
        .id(request.getId())
        .title(request.getTitle())
        .ingredients(request.getIngredients())
        .steps(request.getSteps())
        .chef(chefRequest)
        .chefType(request.getChefType())
        .build();

    RecipeResponseDTO expectedDto = RecipeResponseDTO.builder()
        .id(recipeEntity.getId())
        .title(recipeEntity.getTitle())
        .ingredients(recipeEntity.getIngredients())
        .steps(recipeEntity.getSteps())
        .chef(null)
        .chefType(recipeEntity.getChefType())
        .season(0)
        .build();

    Recipe faked = Recipe.builder()
        .id(recipeEntity.getId())
        .title(recipeEntity.getTitle())
        .ingredients(recipeEntity.getIngredients())
        .steps(recipeEntity.getSteps())
        .chef(null)
        .chefType(recipeEntity.getChefType())
        .season(0)
        .build();

    when(recipeMapper.toEntity(request)).thenReturn(faked);
    when(recipeRepository.save(faked)).thenReturn(faked);
    when(recipeMapper.toDTO(faked)).thenReturn(expectedDto);

    RecipeResponseDTO result = recipeService.createRecipe(request, request.getChefType());

    
    assertNotNull(result);
    assertEquals(expectedDto.getId(), result.getId());
    assertEquals(expectedDto.getTitle(), result.getTitle());
    }
}
