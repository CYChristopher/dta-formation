/**
 * 24 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihmtools;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import fr.pizzeria.model.CategoriePizza;
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

	/**
	 * Affiche les pizzas par catégorie
	 * 
	 * @param pizzas
	 *            Map des pizzas par catégorie
	 */
	public void listPizzasCateg(Map<CategoriePizza, List<Pizza>> pizzas) {
		pizzas.forEach((categorie, list) -> {
			System.out.println("- " + categorie.toString().toUpperCase() + " - ");
			list.forEach(pizza -> {
				System.out.println("\t" + pizza.toString());
			});
			System.out.println("-> " + list.size() + " pizzas dans la catégorie " + categorie.toString());
		});
	}

}
