/**
 * 24 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihmtools;

import java.util.List;
import java.util.function.Consumer;

import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzasTools {

	/**
	 * Affiche la liste les pizzas
	 * 
	 * @param pizzas
	 *            Tableau des pizzas
	 */
	public void listPizzas(List<Pizza> pizzas) {
		pizzas.forEach(new Consumer<Pizza>() {
			@Override
			public void accept(Pizza pizza) {
				System.out.println(pizza.toString());
			}
		});
	}

}
