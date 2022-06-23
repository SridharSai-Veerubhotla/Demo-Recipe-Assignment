package com.hotel.util;

import com.hotel.exception.RecipeException;
import com.hotel.pojo.Recipe;

public class RecipeUtil {
	
	
	public void validateRecipes(Recipe recipe) {
		

		if(recipe.getCookingInstructions().isBlank() || recipe.getCookingInstructions().isEmpty()) {
			throw new RecipeException("Invalid Coocking Instructions.");
		}
		if(recipe.getRecipeName().isBlank() || recipe.getRecipeName().isEmpty()) {
			throw new RecipeException("Invalid Recipe Name.");
		}
		
		if(recipe.getListOfIngredients().size()<1) {
			throw new RecipeException("List of ingredients is empty.");
		}
		
		if(recipe.getListOfIngredients().stream().filter(ingredients->((ingredients.getName().isBlank() || ingredients.getName().isEmpty()) || (ingredients.getQuantity()<=0) || (ingredients.getQuantityUnits().isBlank() || ingredients.getQuantityUnits().isEmpty()))) .count()>0) {
			throw new RecipeException("Invalid Ingredients List.");	
		}
		
	}
	
	public void recipeIdMandatory(Recipe recipe) {
		
		if(recipe.getRecipeId()==0) {
			throw new RecipeException("Invalid Recipe Id.");
		}
		
	}
	

}
