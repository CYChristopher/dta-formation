/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public interface IPizzaDao {

	Pizza[] findAllPizzas();
	Boolean saveNewPizza(Pizza pizza);
	Boolean updatePizza(String codePizza, Pizza pizza);
	Boolean deletePizza(String codePizza);
	
}
