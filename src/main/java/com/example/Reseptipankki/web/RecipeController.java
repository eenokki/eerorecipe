package com.example.Reseptipankki.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Reseptipankki.domain.Ingredient;
import com.example.Reseptipankki.domain.IngredientRepository;
import com.example.Reseptipankki.domain.Recipe;
import com.example.Reseptipankki.domain.RecipeRepository;

@Controller
public class RecipeController {

	@Autowired
	private RecipeRepository reciRepository;
	
	@Autowired
	private IngredientRepository ingrRepository;
	
	//login mapping
	@RequestMapping(value="/login")
		public String login() {
		return "login";
	}
	
	//mapping for recipelistpage
	@RequestMapping("/recipelist")
	public String recipeList(Model model) {
		model.addAttribute("recipies", reciRepository.findAll());
		return "recipelist";
		}
	
	//mapping for addrecipe page
	@RequestMapping(value = "/add")
	public String addRecipe(Model model){
	 model.addAttribute("recipe", new Recipe());
	 model.addAttribute("ingredient", ingrRepository.findAll());
	 return "addrecipe";
	}
	
	//mapping for add ingredient page
	@RequestMapping(value = "/addingredient")
	public String addIngredient(Model model){
	 model.addAttribute("ingredient", new Ingredient());
	 model.addAttribute("ingredient", ingrRepository.findAll());
	 return "addingredient";
	}
	
	@RequestMapping(value="/recipies", method = RequestMethod.GET)
    public @ResponseBody List<Recipe> recipeListRest() {	
    return (List<Recipe>) reciRepository.findAll();
    } 
	
	//mapping to find recipe by id
	@RequestMapping(value="/recipe/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Recipe> findRecipeRest(@PathVariable("id") Long id) {	
    return reciRepository.findById(id);
	}
	
	//saving to database mappings, redirects to /recipelist page
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Recipe recipe){
	 reciRepository.save(recipe);
	 return "redirect:/recipelist";
	}
	
	//delete by id mappings, redirects to recipelist page
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteRecipe(@PathVariable("id") Long id, Model model){ 
	reciRepository.deleteById(id);
	return "redirect:../recipelist";
	}
	
	//edit, directs to editrecipe page
	@RequestMapping(value = "/edit/{id}")
	public String addRecipe(@PathVariable("id") Long id, Model model){
	model.addAttribute("recipe", reciRepository.findById(id));
	model.addAttribute("ingredient", ingrRepository.findAll());
	return "editrecipe";
	}
	
}
