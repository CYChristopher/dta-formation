/**
 * 24 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.ihmtools.Tools;
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
	public ChoixListerPizza(Integer numeroChoix, String nomChoix, ItemDao<String, Pizza> pizzaDao) {
		super(numeroChoix, nomChoix, pizzaDao);
	}

	@Override
	public Boolean faireUneAction() {
		List<Pizza> lesPizzas = this.getItemDao().getItems();
		new Tools().listPizzas(lesPizzas);
		System.out.println("-> " + lesPizzas.size() + " pizzas dans le catalogue");
		System.out.println();
		return true;
	}
}