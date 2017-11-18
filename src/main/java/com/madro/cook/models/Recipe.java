package com.madro.cook.models;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Recipes")
public class Recipe {

	private String name;
	private String type;
	private String displayName;
	private List<Ingredient> ingredients;
	
	public Recipe(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	public Recipe(String name, String type, String displayName, List<Ingredient> ingredients) {
		super();
		this.name = name;
		this.type = type;
		this.displayName = displayName;
		this.ingredients = ingredients;
	}

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	@DynamoDBHashKey
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@DynamoDBAttribute
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@DynamoDBAttribute
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@DynamoDBAttribute
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
}
