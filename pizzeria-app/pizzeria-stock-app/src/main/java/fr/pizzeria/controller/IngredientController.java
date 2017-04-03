/**
 * 31 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.dao.IIngredientRepository;
import fr.pizzeria.model.Ingredient;

/**
 * @author Christopher CHARLERY
 *
 */
@Controller
public class IngredientController{
	
	/**
	 * 
	 */
	private static final String PAGE_INGREDIENTS_JSP = "ingredients/ingredients";
	@Autowired private IIngredientRepository repository;
	@Autowired

	@RequestMapping(value = "/rest/ingredients", method = RequestMethod.GET)
	@ResponseBody
	public List<Ingredient> findAll(){
		return repository.findAll();
	}
	
	@RequestMapping(value = "/rest/ingredients", method = RequestMethod.POST)
	@ResponseBody
	public void addIngredient(@RequestBody Ingredient ingredient){
		repository.save(ingredient);
	}
	
	@RequestMapping(value = "/ingredients", method = RequestMethod.GET)
	public ModelAndView ingredientsVue(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(PAGE_INGREDIENTS_JSP);
		mav.addObject("list", repository.findAll());
		return mav;
	}
	
	@RequestMapping(value = "/ingredients/{id}", method = RequestMethod.GET)
	public String setupForm(@PathVariable Integer id, Model model){
		Ingredient ingredient = repository.findOne(id);
		model.addAttribute("ingredient", ingredient);
		return "ingredients/ingredientForm";
	}
	
	@RequestMapping(value = "/ingredients/{id}", method = RequestMethod.POST)
	public String setupForm(@ModelAttribute("ingredient") Ingredient ingredient){
		repository.save(ingredient);
		return "redirect:/mvc/ingredients";
	}
	
}
