/**
 * 24 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.List;

import fr.pizzeria.dao.IItemDao;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.ihmtools.PizzasTools;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
final class ChoixListerPizza extends Choix<String, Pizza> {
	
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 */
	public ChoixListerPizza(Integer numeroChoix, String nomChoix, IItemDao<String, Pizza> pizzaDao) {
		super(numeroChoix, nomChoix, pizzaDao);
	}

	@Override
	public Boolean faireUneAction() {
		List<Pizza> lesPizzas = this.getItemDao().findAllItems();
		new PizzasTools().listPizzas(lesPizzas);
		System.out.println("-> " + lesPizzas.size() + " pizzas dans le menu");
		System.out.println();
		return true;
	}
}