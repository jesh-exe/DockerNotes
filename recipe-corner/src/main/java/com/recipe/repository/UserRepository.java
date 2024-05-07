package com.recipe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmailAndPassword(String email, String password);

}
