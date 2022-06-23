package com.hotel.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredients {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	int ingredientId;
	String name;
	long quantity;
	String quantityUnits;

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getQuantityUnits() {
		return quantityUnits;
	}

	public void setQuantityUnits(String quantityUnits) {
		this.quantityUnits = quantityUnits;
	}

	@Override
	public String toString() {
		return "Ingredients [ingredientId=" + ingredientId + ", name=" + name + ", quantity=" + quantity
				+ ", quantityUnits=" + quantityUnits + "]";
	}

}
