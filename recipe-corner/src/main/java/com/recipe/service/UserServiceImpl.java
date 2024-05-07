package com.recipe.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.dto.RecipeResponseDto;
import com.recipe.dto.UserResponseDto;
import com.recipe.dto.UserSignUpRequestDto;
import com.recipe.dto.UserValidateRequestDTO;
import com.recipe.entity.Recipe;
import com.recipe.entity.User;
import com.recipe.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String signUp(UserSignUpRequestDto userRequestDto) {
		User user = mapper.map(userRequestDto, User.class);
		userRepository.save(user);
		return "Sign Up Successful";
	}

	@Override
	public UserResponseDto validateUser(UserValidateRequestDTO userRequest) {
		User user = userRepository.findByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword()).orElseThrow(() -> new RuntimeException());
		
		List<RecipeResponseDto> recipeResponseList = new ArrayList<>();
		for(Recipe recipe : user.getMyRecipes())
		{
			RecipeResponseDto recipeResponse = mapper.map(recipe, RecipeResponseDto.class);
			recipeResponseList.add(recipeResponse);
		}
		UserResponseDto userResponse = new UserResponseDto(user.getId(), user.getName(), user.getEmail(), recipeResponseList);
		System.out.println(userResponse);
		return userResponse;
	}
	
}
