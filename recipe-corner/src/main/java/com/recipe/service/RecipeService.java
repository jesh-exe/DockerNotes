package com.recipe.service;

import java.util.List;

import com.recipe.dto.RecipeRequestDto;
import com.recipe.entity.Recipe;

public interface RecipeService {

	List<Recipe> addRecipes(List<RecipeRequestDto> recipes);

	List<Recipe> addRecipe(RecipeRequestDto recipeDto,Integer userId);

	Recipe getRecipe(Integer id);

	List<Recipe> getAllRecipes();

	List<Recipe> deleteRecipe(Integer userId,Integer recipeId);

	List<Recipe> updateRecipe(RecipeRequestDto recipeRequestDto,Integer userId);

}
