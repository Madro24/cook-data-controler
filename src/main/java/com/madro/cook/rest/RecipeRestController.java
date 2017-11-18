package com.madro.cook.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("/recipes/{name}")
	public Recipe getRecipe(@PathVariable(value = "name") String name) {
		return recipeRepository.findByName(name);
	}
	
	@RequestMapping(method= {RequestMethod.POST, RequestMethod.PUT}, value="/recipes")
	public List<Recipe> addRecipe(@RequestBody Recipe recipe) {
		recipeRepository.save(recipe);
		return getRecipes();
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value="/recipes/{name}")
	public List<Recipe> removeRecipe(@PathVariable(value = "name") String name) {
		recipeRepository.delete(name);
		return getRecipes();
	}
}
