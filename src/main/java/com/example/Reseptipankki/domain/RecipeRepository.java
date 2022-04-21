package com.example.Reseptipankki.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//repository for recipe class
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
	List<Recipe> findByName(String name);
	}