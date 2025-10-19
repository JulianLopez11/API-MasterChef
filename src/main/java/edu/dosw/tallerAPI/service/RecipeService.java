package edu.dosw.tallerAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import edu.dosw.tallerAPI.exception.ResourceNotFoundException;
import edu.dosw.tallerAPI.mapper.RecipeMapper;
import edu.dosw.tallerAPI.model.dtos.request.RecipeRequestDTO;
import edu.dosw.tallerAPI.model.dtos.response.RecipeResponseDTO;
import edu.dosw.tallerAPI.model.entity.Recipe;
import edu.dosw.tallerAPI.model.entity.enums.ChefType;
import edu.dosw.tallerAPI.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    /**
     * Creates a new recipe associated with a specific {@link ChefType}.
     * @param dto the data transfer object containing recipe details.
     * @param chefType the type of chef creating the recipe (VIEWER, COMPETITOR, JURY).
     * @return the created recipe as a recipe
     */
    @Transactional
    public RecipeResponseDTO createRecipe(RecipeRequestDTO dto, ChefType chefType) {
        Recipe recipe = recipeMapper.toEntity(dto);
        recipe.setChefType(chefType);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return recipeMapper.toDTO(savedRecipe);
    }

    /**
     * Retrieves all recipes stored in the database.
     *
     * @return a list of recipes representing all recipes.
     */
    @Transactional
    public List<RecipeResponseDTO> getAllRecipes() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a recipe by its unique ID.
     *
     * @param id the ID of the recipe.
     * @return a recipe representing the found recipe.
     * @throws ResourceNotFoundException 
     */
    @Transactional
    public RecipeResponseDTO getRecipeById(String id) {
        Recipe recipe = recipeRepository.findRecipeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found"));
        return recipeMapper.toDTO(recipe);
    }

    /**
     * Retrieves recipes based on the type of chef who created them.
     * @param chef (VIEWER, COMPETITOR, JURY).
     * @return a list of recipe matching the chef type.
     */
    @Transactional
    public List<RecipeResponseDTO> getRecipesByChefType(ChefType chef) {
        return recipeRepository.findByChefType(chef)
                .stream()
                .map(recipeMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves recipes from a specific season.
     * @param season the season number.
     * @return a list of recipes that belong to the season asked.
     */
    @Transactional
    public List<RecipeResponseDTO> getRecipesBySeason(int season) {
        return recipeRepository.findBySeason(season)
                .stream()
                .map(recipeMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves recipes containing a specific ingredient.
     * @param ingredient the ingredient to search for.
     * @return a list of recipes that include the ingredient asked.
     */
    @Transactional
    public List<RecipeResponseDTO> getRecipesByIngredient(String ingredient) {
        return recipeRepository.findByIngredients(ingredient)
                .stream()
                .map(recipeMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Deletes a recipe by its ID.
     * @param id the ID of the recipe to delete.
     * @throws ResourceNotFoundException
     */
    @Transactional
    public void deleteRecipe(String id) {
        if (!recipeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recipe not found");
        }
        recipeRepository.deleteById(id);
    }

    /**
     * Updates an existing recipe by its ID.
     * @param id the ID of the recipe to update.
     * @param dto the new recipe data.
     * @return the updated Recipe
     * @throws ResourceNotFoundException 
     */
    @Transactional
    public RecipeResponseDTO updateRecipe(String id, RecipeRequestDTO dto) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found"));

        recipe.setTitle(dto.getTitle());
        recipe.setIngredients(dto.getIngredients());
        recipe.setSteps(dto.getSteps());
        recipe.setChef(dto.getChef());
        recipe.setChefType(dto.getChefType());
        recipe.setSeason(dto.getSeason());

        Recipe updatedRecipe = recipeRepository.save(recipe);
        return recipeMapper.toDTO(updatedRecipe);
    }
}
