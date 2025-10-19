package edu.dosw.tallerAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.dosw.tallerAPI.model.dtos.request.RecipeRequestDTO;
import edu.dosw.tallerAPI.model.dtos.response.RecipeResponseDTO;
import edu.dosw.tallerAPI.model.entity.enums.ChefType;
import edu.dosw.tallerAPI.service.RecipeService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping("/viewer")
    public ResponseEntity<RecipeResponseDTO> createViewerRecipe(@RequestBody RecipeRequestDTO recipeRequestDTO) {
        RecipeResponseDTO createdRecipe = recipeService.createRecipe(recipeRequestDTO,ChefType.VIEWER);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipe);
    }

    @PostMapping("/jury")
    public ResponseEntity<RecipeResponseDTO> createJuryRecipe(@RequestBody RecipeRequestDTO recipeRequestDTO) {
        RecipeResponseDTO createdRecipe = recipeService.createRecipe(recipeRequestDTO,ChefType.JURY);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipe);
    }

    @PostMapping("/competitor")
    public ResponseEntity<RecipeResponseDTO> createCompetitorRecipe(@RequestBody RecipeRequestDTO recipeRequestDTO) {
        RecipeResponseDTO createdRecipe = recipeService.createRecipe(recipeRequestDTO,ChefType.COMPETITOR);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipe);
    }

    @GetMapping("/recipes")
    public List<RecipeResponseDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponseDTO> getRecipeById(@PathVariable String id) {
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    @GetMapping("/competitor")
    public ResponseEntity<List<RecipeResponseDTO>> getCompetitorRecipes() {
        return ResponseEntity.ok(recipeService.getRecipesByChefType(ChefType.COMPETITOR));
    }

    @GetMapping("/viewer")
    public ResponseEntity<List<RecipeResponseDTO>> getViewerRecipes() {
        return ResponseEntity.ok(recipeService.getRecipesByChefType(ChefType.VIEWER));
    }

    @GetMapping("/jury")
    public ResponseEntity<List<RecipeResponseDTO>> getJuryRecipes() {
        return ResponseEntity.ok(recipeService.getRecipesByChefType(ChefType.JURY));
    }

    @GetMapping("/season/{season}")
    public ResponseEntity<List<RecipeResponseDTO>> getRecipesBySeason(@PathVariable int season) {
        return ResponseEntity.ok(recipeService.getRecipesBySeason(season));
    }

    @GetMapping("/recipe/{ingredient}")
    public ResponseEntity<List<RecipeResponseDTO>> getRecipesByIngredient(@PathVariable String ingredient) {
        return ResponseEntity.ok(recipeService.getRecipesByIngredient(ingredient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable String id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeResponseDTO> updateRecipe(@PathVariable String id, @RequestBody RecipeRequestDTO dto) {
        return ResponseEntity.ok(recipeService.updateRecipe(id, dto));
    }
    
}
