package com.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.dto.UserSignUpRequestDto;
import com.recipe.dto.UserValidateRequestDTO;
import com.recipe.service.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> signUp(@RequestBody UserSignUpRequestDto userRequestDto )
	{
		return ResponseEntity.status(HttpStatus.OK).body(userService.signUp(userRequestDto));
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody UserValidateRequestDTO user)
	{
		return ResponseEntity.status(HttpStatus.OK).body(userService.validateUser(user));
	}
	
}
