package edu.dosw.tallerAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.dosw.tallerAPI.model.entity.Recipe;
import edu.dosw.tallerAPI.model.entity.enums.ChefType;

public interface RecipeRepository extends MongoRepository<Recipe,String> {

    List<Recipe> findBySeason(int season);
    List<Recipe> findByChefId(String chefId);
    Optional<Recipe> findRecipeById(String id);
    List<Recipe> findByChefType(ChefType type);
    List<Recipe> findByIngredients(String ingredient);
    
}
