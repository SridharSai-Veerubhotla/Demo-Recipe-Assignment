package com.hotel.pojo;

public class UserRecipes {

	int userId;
	int recipeId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRecipeId() {
		return recipeId;
	}

	@Override
	public String toString() {
		return "UserRecipes [userId=" + userId + ", recipeId=" + recipeId + "]";
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

}
