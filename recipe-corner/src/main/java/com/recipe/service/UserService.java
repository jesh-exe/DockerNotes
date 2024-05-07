package com.recipe.service;

import java.util.Optional;

import com.recipe.dto.UserResponseDto;
import com.recipe.dto.UserSignUpRequestDto;
import com.recipe.dto.UserValidateRequestDTO;
import com.recipe.entity.User;

public interface UserService {

	String signUp(UserSignUpRequestDto userRequestDto);

	UserResponseDto validateUser(UserValidateRequestDTO user);
	

}
