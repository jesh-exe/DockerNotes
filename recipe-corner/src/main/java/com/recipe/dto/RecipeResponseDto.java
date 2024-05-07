package com.recipe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecipeResponseDto {

	private Integer id;
	private String name;
	private String ingredients;
	private String instructions;
	private int prepTimeMinutes;
	private int cookTimeMinutes;
	private int servings;
	private String difficulty;
	private String cuisine;
	private int caloriesPerServing;
	private String tags;
	private String image;
	private double rating;
	
}
