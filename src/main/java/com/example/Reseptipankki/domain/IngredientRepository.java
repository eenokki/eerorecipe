package com.example.Reseptipankki.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//repository for ingredients
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	
	List<Ingredient> findByName(String name);

}