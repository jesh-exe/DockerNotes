package com.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.dto.RecipeRequestDto;
import com.recipe.service.RecipeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/recipes")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@PostMapping("/add/{userId}")
	private ResponseEntity<?> addRecipe(@RequestBody RecipeRequestDto recipeDto, @PathVariable Integer userId) {
		System.out.println(recipeDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(recipeService.addRecipe(recipeDto,userId));
	}

	@PostMapping("/add-all")
	private ResponseEntity<?> addRecipes(@RequestBody List<RecipeRequestDto> recipeListDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(recipeService.addRecipes(recipeListDto));
	}

	@GetMapping("/{id}")
	private ResponseEntity<?> getRecipe(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(recipeService.getRecipe(id));
	}

	@GetMapping
	private ResponseEntity<?> getRecipes() {
		return ResponseEntity.status(HttpStatus.OK).body(recipeService.getAllRecipes());
	}

	@DeleteMapping("/{userId}/{recipeId}")
	private ResponseEntity<?> deleteRecipe(@PathVariable Integer userId,@PathVariable Integer recipeId) {
		return ResponseEntity.status(HttpStatus.OK).body(recipeService.deleteRecipe(userId,recipeId));
	}

	@PutMapping("/{userId}")
	private ResponseEntity<?> updateRecipe(@RequestBody RecipeRequestDto recipeRequestDto, @PathVariable Integer userId) {
		return ResponseEntity.status(HttpStatus.OK).body(recipeService.updateRecipe(recipeRequestDto,userId));
	}
}







