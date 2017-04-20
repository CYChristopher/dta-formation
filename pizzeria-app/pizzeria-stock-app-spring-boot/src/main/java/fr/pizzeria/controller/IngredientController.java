/**
 * 31 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
import fr.pizzeria.dao.PerformanceRepository;
import fr.pizzeria.model.Ingredient;

/**
 * @author Christopher CHARLERY
 *
 */
@Controller
public class IngredientController {

	/**
	 * 
	 */
	private static final String PAGE_INGREDIENTS_JSP = "ingredients";
	@Autowired
	private IIngredientRepository ingredientRepository;
	@Autowired
	private PerformanceRepository performanceRepository;

	@RequestMapping(value = "/rest/ingredients", method = RequestMethod.GET)
	@ResponseBody
	public List<Ingredient> findAll() {
		return ingredientRepository.findAll();
	}

	@RequestMapping(value = "/rest/ingredients", method = RequestMethod.POST)
	@ResponseBody
	public void addIngredient(@RequestBody Ingredient ingredient) {
		ingredientRepository.save(ingredient);
	}

	@RequestMapping(value = "page/ingredients", method = RequestMethod.GET)
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	public ModelAndView ingredientsVue() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(PAGE_INGREDIENTS_JSP);
		mav.addObject("list", ingredientRepository.findAll());
		return mav;
	}

	@RequestMapping(value = "page/ingredients/{id}", method = RequestMethod.GET)
	public String setupForm(@PathVariable Integer id, Model model) {
		Ingredient ingredient = ingredientRepository.findOne(id);
		model.addAttribute("ingredient", ingredient);
		return "ingredientForm";
	}

	@RequestMapping(value = "page/ingredients/{id}", method = RequestMethod.POST)
	public String setupForm(@ModelAttribute("ingredient") Ingredient ingredient) {
		ingredientRepository.save(ingredient);
		return "redirect:/page/ingredients";
	}

	@RequestMapping(value = "page/performances", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ModelAndView performancesVue() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("performances");
		mav.addObject("list", performanceRepository.findAll());
		return mav;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String getLogin(){
		return "login";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(){
		return "redirect:index.html";
	}

}
