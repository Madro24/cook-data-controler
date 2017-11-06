package com.madro.cook.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madro.cook.data.dynamodb.repositories.RecipeRepository;
import com.madro.cook.models.Recipe;

@RestController
public class RecipeRestController {

	@Autowired private RecipeRepository recipeRepository;
	
	@RequestMapping("/recipes")
	public List<Recipe> getRecipes() {
		return (List<Recipe>) recipeRepository.findAll();
	}
	
	@RequestMapping("/recipes/{id}")
	public List<Recipe> getRecipeById(@PathVariable(value = "id") String id) {
		return recipeRepository.findById(id);
	}
}
