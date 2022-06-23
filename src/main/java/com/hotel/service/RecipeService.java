package com.hotel.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.exception.RecipeException;
import com.hotel.pojo.Recipe;
import com.hotel.repository.RecipeRepository;
import com.hotel.util.RecipeUtil;

@Service
public class RecipeService {

	@Autowired
	RecipeRepository recipieRepository;

	RecipeUtil util = new RecipeUtil();

	public Recipe createRecipe(Recipe recipe) {
		util.validateRecipes(recipe);
		recipe.setCreationTime(new Date());
		recipe.setModifiedTime(new Date());
		return recipieRepository.save(recipe);
	}

	public Recipe deleteRecipe(Recipe recipe) {
		Recipe retrivedRecipe = recipieRepository.getRecipeByRecipeId(recipe.getRecipeId());
		if (retrivedRecipe==null) {
			throw new RecipeException("Invalid Recipe to delete.");
		} else {
			return recipieRepository.deleteById(recipe.getRecipeId());
		}
	}
	
	
	public Recipe deleteRecipeById(int id) {
		Recipe retrivedRecipe = recipieRepository.getRecipeByRecipeId(id);
		if (retrivedRecipe==null) {
			throw new RecipeException("No Recipe available with Recipe Id "+id);
		} else {
			return recipieRepository.deleteById(id);
		}
	}
	
	
	public Recipe deleteRecipeByname(String name) {
		List<Recipe> retrivedRecipes = recipieRepository.getRecipeByRecipeName(name);
		if (retrivedRecipes.size()<1) {
			throw new RecipeException("No Recipe available with name "+name);
		} else {
			return recipieRepository.deleteByRecipeName(name);
		}
	}

	public Recipe updateRecipe(Recipe recipe) {
		Recipe retrivedRecipe = recipieRepository.getRecipeByRecipeId(recipe.getRecipeId());

		if (retrivedRecipe==null) {
			throw new RecipeException("Invalid Recipe to update.");
		} else {

			recipe.setModifiedTime(new Date());
			return recipieRepository.save(recipe);
		}

	}

	public List<Recipe> getAllRecipes() {

		List<Recipe> allRecipes = recipieRepository.findAll();
		if (allRecipes.size() == 0) {
			throw new RecipeException("No Recipes currently available.");
		} else {
			return allRecipes;
		}

	}

	public List<Recipe> getRecipesByPreference(boolean isVegeterian) {

		List<Recipe> allRecipes = recipieRepository.getRecipeByIsVegeterian(isVegeterian);
		if (allRecipes.size() == 0) {
			if (isVegeterian) {
				throw new RecipeException("No Recipes currently available in Vegeterian category.");
			} else {
				throw new RecipeException("No Recipes currently available in Non-Vegeterian Category.");
			}

		} else {
			return recipieRepository.getRecipeByIsVegeterian(isVegeterian);
		}

	}

	public List<Recipe> getRecipesByName(String name) {
		List<Recipe> allRecipes = recipieRepository.getRecipeByRecipeName(name);
		if (allRecipes.size() == 0) {
			throw new RecipeException("No Recipes currently available with name " + name + ".");
		} else {
			return recipieRepository.getRecipeByRecipeName(name);
		}

	}

	public Recipe getRecipeById(int recipeId) {

		return recipieRepository.getRecipeByRecipeId(recipeId);
	}

}
