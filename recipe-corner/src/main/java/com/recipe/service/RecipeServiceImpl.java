package com.recipe.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.engine.query.spi.ReturnMetadata;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.dto.RecipeRequestDto;
import com.recipe.entity.Recipe;
import com.recipe.entity.User;
import com.recipe.repository.RecipeRepository;
import com.recipe.repository.UserRepository;

import lombok.experimental.PackagePrivate;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Recipe> addRecipes(List<RecipeRequestDto> recipes) {
		List<Recipe> recipeList = new ArrayList<Recipe>();
		for (RecipeRequestDto recipe : recipes) {
			Recipe recipeObject = mapper.map(recipe, Recipe.class);
			recipeList.add(recipeObject);
		}
		recipeRepository.saveAll(recipeList);
		return recipeRepository.findAll();
	}

	@Override
	public List<Recipe> addRecipe(RecipeRequestDto recipeDto, Integer userId) {
		User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException());
		Recipe objRecipe = mapper.map(recipeDto, Recipe.class);
		user.setRecipe(objRecipe);
		userRepository.save(user);
		return user.getMyRecipes();
	}

	@Override
	public Recipe getRecipe(Integer id) {
		return recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found!"));
	}

	@Override
	public List<Recipe> getAllRecipes() {
		return recipeRepository.findAll();
	}

	@Override
	public List<Recipe> deleteRecipe(Integer userId,Integer recipeId) {
		User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException());
		Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(()->new RuntimeException());
		user.deleteRecipe(recipe);
		return user.getMyRecipes();
		
	}

	@Override
	public List<Recipe> updateRecipe(RecipeRequestDto recipeRequestDto,Integer userId) {
		User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException());
		Recipe obj = recipeRepository.findById(recipeRequestDto.getId()).orElseThrow();
		obj = mapper.map(recipeRequestDto, Recipe.class);
		obj.setMyUser(user);
		int index = user.getMyRecipes().indexOf(obj);
		System.out.println(index);
		user.getMyRecipes().set(index, obj);
		userRepository.save(user);
		return user.getMyRecipes();
	}

}
