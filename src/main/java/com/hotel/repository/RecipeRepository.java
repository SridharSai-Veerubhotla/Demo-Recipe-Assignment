package com.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.pojo.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
	
	
	List<Recipe> findAll();
	Recipe save(Recipe recipe);
	Recipe deleteById(int recipieId);
	Recipe deleteByRecipeName(String recipeName);
	Recipe getRecipeByRecipeId(int recipieId);
	List<Recipe> getRecipeByRecipeName(String recipeName);	
	List<Recipe> getRecipeByIsVegeterian(boolean isVegeterian);

}
