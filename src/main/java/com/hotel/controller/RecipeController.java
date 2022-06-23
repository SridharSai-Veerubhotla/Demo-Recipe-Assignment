package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.pojo.Recipe;
import com.hotel.service.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

	@Autowired
	RecipeService service;

	@PostMapping("/create")
	public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
		Recipe re = service.createRecipe(recipe);
		return new ResponseEntity<>(re, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<Recipe> modifyRecipe(@RequestBody Recipe recipe) {
		Recipe re = service.updateRecipe(recipe);
		return new ResponseEntity<>(re, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Recipe> deleteRecipe(@RequestBody Recipe recipe) {
		Recipe re = service.deleteRecipe(recipe);
		return new ResponseEntity<>(re, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById")
	public ResponseEntity<Recipe> deleteRecipe(@RequestBody int id) {
		Recipe re = service.deleteRecipeById(id);
		return new ResponseEntity<>(re, HttpStatus.OK);
	}

	@DeleteMapping("/deleteByName")
	public ResponseEntity<Recipe> deleteRecipe(@RequestBody String name) {
		Recipe re = service.deleteRecipeByname(name);
		return new ResponseEntity<>(re, HttpStatus.OK);
	}

	@GetMapping("/getAllRecipes")
	public ResponseEntity<List<Recipe>> getAll() {
		List<Recipe> re = service.getAllRecipes();
		return new ResponseEntity<>(re, HttpStatus.OK);
	}

	/*
	 * @GetMapping("getRecipeById/{id}") public ResponseEntity<Recipe>
	 * getRecipeById(@PathVariable int i) { Recipe re = service.getRecipeById(i);
	 * return new ResponseEntity<>(re, HttpStatus.OK); }
	 */

	@GetMapping("getRecipeByPreference/isVegeterian={isVegeterian}")
	public ResponseEntity<List<Recipe>> getRecipeByPreference(@PathVariable boolean isVegeterian) {
		List<Recipe> re = service.getRecipesByPreference(isVegeterian);
		return new ResponseEntity<>(re, HttpStatus.OK);
	}

	@GetMapping("getRecipesByName/{name}")
	public ResponseEntity<List<Recipe>> getRecipeById(@PathVariable String name) {
		List<Recipe> re = service.getRecipesByName(name);
		return new ResponseEntity<>(re, HttpStatus.OK);
	}

}
