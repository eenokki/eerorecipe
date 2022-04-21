package com.example.Reseptipankki;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.example.Reseptipankki.domain.Recipe;
import com.example.Reseptipankki.domain.RecipeRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RecipeRepositoryTests {
	
	@Autowired
	private RecipeRepository repository;
	
	//test to see if you can find recipe with it's name
	@Test
	public void findByNameShouldReturnRecipe() {
		List <Recipe> recipies = repository.findByName("Sima");
		
		assertThat(recipies).hasSize(1);
		assertThat(recipies.get(0).getName()).isEqualTo("Sima");
	}
	
	//test to see if you can create new recipe
	@Test
    public void createNewRecipe() {
    	Recipe recipe = new Recipe("Nakki", "nakki.com", "Se on nakki", "Muussaa lihaa. Pistä se suoleen.");
    	repository.save(recipe);
    	assertThat(recipe.getId()).isNotNull();
	}
	
	//test to see if you can delete recipe
	@Test
	public void deleteRecipe () {
		List <Recipe> recipies = repository.findByName("Sima");
		Recipe recipe= recipies.get(0);
		repository.delete(recipe);
		
		List<Recipe> newRecipe = repository.findByName("Sima");
		assertThat(newRecipe).hasSize(0);
	}
	
}
