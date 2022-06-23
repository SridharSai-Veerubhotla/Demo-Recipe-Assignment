package com.hotel.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Recipe implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int recipeId;
	String recipeName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="recipe_ingredientId",nullable=false)
	List<Ingredients> listOfIngredients;
	@JsonFormat(pattern="dd‐MM‐yyyy HH:mm")
	Date creationTime;
	@JsonFormat(pattern="dd‐MM‐yyyy HH:mm")
	Date modifiedTime;
	boolean isVegeterian;
	String cookingInstructions;

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	
	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public List<Ingredients> getListOfIngredients() {
		return listOfIngredients;
	}

	public void setListOfIngredients(List<Ingredients> listOfIngredients) {
		this.listOfIngredients = listOfIngredients;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public boolean isVegeterian() {
		return isVegeterian;
	}

	public void setVegeterian(boolean isVegeterian) {
		this.isVegeterian = isVegeterian;
	}

	public String getCookingInstructions() {
		return cookingInstructions;
	}

	public void setCookingInstructions(String cookingInstructions) {
		this.cookingInstructions = cookingInstructions;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeName=" + recipeName + ", listOfIngredients="
				+ listOfIngredients + ", creationTime=" + creationTime + ", modifiedTime=" + modifiedTime
				+ ", isVegeterian=" + isVegeterian + ", cookingInstructions=" + cookingInstructions + "]";
	}

	

	

}
