package com.madro.cook.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Ingredient {
	private String ingredient;
	private int quantity;
	
	public Ingredient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ingredient(String ingredient, int quantity) {
		super();
		this.ingredient = ingredient;
		this.quantity = quantity;
	}

	@DynamoDBAttribute
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	@DynamoDBAttribute
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
