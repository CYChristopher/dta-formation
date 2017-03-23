/**
 * 22 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class DaoTool {
	public static final ItemDao<String, Pizza> daoJpa = new PizzaDaoJpa();
}
