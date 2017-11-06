package com.madro.cook.data.dynamodb.repositories;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.madro.cook.models.Recipe;

@EnableScan
public interface RecipeRepository extends CrudRepository<Recipe, String> {

	List<Recipe> findById(String id);
}
