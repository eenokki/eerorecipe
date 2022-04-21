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

import com.example.Reseptipankki.domain.Ingredient;
import com.example.Reseptipankki.domain.IngredientRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IngredientRepositoryTests {
	
	@Autowired
	private IngredientRepository repository;
	
	//findByName test. Compares to the given name.
	@Test
	public void findByNameShouldReturnIngredient() {
		List<Ingredient> ingredients = repository.findByName("");
		
		assertThat(ingredients).hasSize(1);
		assertThat(ingredients.get(0).getName()).isEqualTo("");
	}
	
	//Test to see if new ingredient can be created
	@Test
    public void createNewIngredient() {
    	Ingredient ingredient = new Ingredient();
    	repository.save(ingredient);
    	assertThat(ingredient.getId()).isNotNull();
	}
	
	//ingredient deletation test
	@Test
	public void deleteIngredient () {
		List <Ingredient> ingredients = repository.findByName("");
		Ingredient ingredient= ingredients.get(0);
		repository.delete(ingredient);
		
		List<Ingredient> newIngredient = repository.findByName("");
		assertThat(newIngredient).hasSize(0);
	}
	

}
