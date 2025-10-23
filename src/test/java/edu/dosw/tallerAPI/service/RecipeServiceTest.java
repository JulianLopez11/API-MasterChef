package edu.dosw.tallerAPI.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.dosw.tallerAPI.exception.ResourceNotFoundException;
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
    void shouldCreateCompetitorRecipe(){

        Chef competitorChef = Chef.builder()
            .id("1")
            .name("Jorge Raush")
            .chefType(ChefType.COMPETITOR)
            .build();
        
        RecipeRequestDTO recipeRequest = RecipeRequestDTO.builder()
            .id("1")
            .title("Rice")
            .ingredients(List.of("Water","Onion","Rice","Salt","Oil"))
            .steps(List.of("Boil Water","Cut Onion", "Mix Onion rice And water in the pot","Wait","Put the rice"))
            .chef(competitorChef)
            .season(1)
            .build();

        Recipe recipeEntity = Recipe.builder()
            .id(recipeRequest.getId())
            .title(recipeRequest.getTitle())
            .ingredients(recipeRequest.getIngredients())
            .steps(recipeRequest.getSteps())
            .chef(competitorChef)
            .season(recipeRequest.getSeason())
            .build();

        RecipeResponseDTO expectedResponse = RecipeResponseDTO.builder()
            .id(recipeEntity.getId())
            .title(recipeEntity.getTitle())
            .ingredients(recipeEntity.getIngredients())
            .steps(recipeEntity.getSteps())
            .chef(null)
            .season(recipeEntity.getSeason())
            .build();

        when(recipeRepository.save(any(Recipe.class))).thenReturn(recipeEntity);
        when(recipeMapper.toDTO(any(Recipe.class))).thenReturn(expectedResponse);

        RecipeResponseDTO resultResponse = recipeService.createCompetitorRecipe(recipeRequest);

        assertEquals("1", resultResponse.getId());
        assertEquals("Rice", resultResponse.getTitle());
        assertEquals(1, resultResponse.getSeason());
        verify(recipeRepository).save(any(Recipe.class));
        verify(recipeMapper).toDTO(any(Recipe.class));
    }

    @Test
    void shouldCreateJuryRecipe(){

        Chef juryChef = Chef.builder()
            .id("1")
            .name("Julian Lopez")
            .chefType(ChefType.JURY)
            .build();
        
        RecipeRequestDTO recipe = RecipeRequestDTO.builder()
            .id("1")
            .title("Rice")
            .ingredients(List.of("Water","Onion","Rice","Salt","Oil"))
            .steps(List.of("Boil Water","Cut Onion", "Mix Onion rice And water in the pot","Wait","Put the rice"))
            .chef(juryChef)
            .season(1)
            .build();

        Recipe recipeEntity = Recipe.builder()
            .id(recipe.getId())
            .title(recipe.getTitle())
            .ingredients(recipe.getIngredients())
            .steps(recipe.getSteps())
            .chef(juryChef)
            .season(recipe.getSeason())
            .build();

        RecipeResponseDTO expectedResponse = RecipeResponseDTO.builder()
            .id(recipeEntity.getId())
            .title(recipeEntity.getTitle())
            .ingredients(recipeEntity.getIngredients())
            .steps(recipeEntity.getSteps())
            .chef(null)
            .season(recipeEntity.getSeason())
            .build();

         when(recipeRepository.save(any(Recipe.class))).thenReturn(recipeEntity);
        when(recipeMapper.toDTO(any(Recipe.class))).thenReturn(expectedResponse);

        RecipeResponseDTO result = recipeService.createJuryRecipe(recipe);

        assertEquals("1", result.getId());
        assertEquals("Rice", result.getTitle());
        assertEquals(1, result.getSeason());
        verify(recipeRepository).save(any(Recipe.class));
        verify(recipeMapper).toDTO(any(Recipe.class));
    }

    @Test
    void shouldCreateViewerRecipe(){

        Chef viewerChef = Chef.builder()
            .id("1")
            .name("Frank Cuesta")
            .chefType(ChefType.VIEWER)
            .build();
        
        RecipeRequestDTO recipe = RecipeRequestDTO.builder()
            .id("1")
            .title("Lemon Chicken")
            .ingredients(List.of("Lemon","Black pepper","Paprika","Salt","Olive Oil","Chicken","Oregano"))
            .steps(List.of("Mix Olive Oil, Black Pepper, Paprika, Salt, Oregano, and Lemon Juice","Add Chicken",
                "Marinate for the time you want","Add it to the AirFryer at mode Chicken"))
            .chef(viewerChef)
            .season(1)
            .build();

        Recipe recipeEntity = Recipe.builder()
            .id(recipe.getId())
            .title(recipe.getTitle())
            .ingredients(recipe.getIngredients())
            .steps(recipe.getSteps())
            .chef(viewerChef)
            .season(recipe.getSeason())
            .build();

        RecipeResponseDTO expectedResponse = RecipeResponseDTO.builder()
            .id(recipeEntity.getId())
            .title(recipeEntity.getTitle())
            .ingredients(recipeEntity.getIngredients())
            .steps(recipeEntity.getSteps())
            .chef(null)
            .season(recipeEntity.getSeason())
            .build();

        when(recipeRepository.save(any(Recipe.class))).thenReturn(recipeEntity);
        when(recipeMapper.toDTO(any(Recipe.class))).thenReturn(expectedResponse);

        RecipeResponseDTO result = recipeService.createViewerRecipe(recipe);

        assertNotNull(result);
        assertEquals(expectedResponse.getId(), result.getId());
        assertEquals(expectedResponse.getTitle(), result.getTitle());
        assertEquals(expectedResponse.getSeason(), result.getSeason());
        verify(recipeRepository).save(recipeEntity);
        verify(recipeMapper).toDTO(recipeEntity);
    }
    
    

    @Test
    void shouldSearchRecipeByIngredient(){
        Recipe recipe = Recipe.builder()
            .id("")
            .title("Chocolate")
            .ingredients(List.of("Water", "Milk", "Chocolate"))
            .steps(List.of("Boil water", "Add milk","Add chocolate","wait"))
            .build();
        when(recipeRepository.findByIngredients("Water")).thenReturn(List.of(recipe));
        when(recipeMapper.toDTO(recipe)).thenReturn(RecipeResponseDTO.builder().id(recipe.getId()).title(recipe.getTitle()).build());
        List<RecipeResponseDTO> result = recipeService.getRecipesByIngredient("Water");
        assertNotNull(result);
        assertEquals(recipe.getId(), result.get(0).getId());
        assertEquals(recipe.getTitle(), result.get(0).getTitle());
        
    }

    @Test
    void shouldThrowErrorWhenRecipeNotFound(){
        Chef chef = Chef.builder()
            .id("1")
            .name("Gordon Ramsey")
            .chefType(ChefType.JURY)
            .build();
        RecipeRequestDTO recipeDTO = RecipeRequestDTO.builder()
            .id("1")
            .title("Pasta")
            .ingredients(List.of("Flour", "Eggs", "Salt"))
            .steps(List.of("Boil water", "Cook pasta","Add sauce"))
            .chef(chef)
            .build();
    
        when(recipeRepository.findById("1")).thenReturn(Optional.empty());
    
        assertThrows(ResourceNotFoundException.class, () -> recipeService.updateRecipe("1", recipeDTO));
        verify(recipeRepository).findById("1");

    }
}
