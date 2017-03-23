/**
 * 23 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.admin.metier;

import java.util.List;

import javax.inject.Inject;

import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzaService {
	@Inject private ItemDao<String, Pizza> pizzaDao;
	
	public List<Pizza> findAllPizzas(){
		pizzaDao.findAllItems();
		return pizzaDao.getItems();
	}
	
	public void deletePizza(String code) throws StockageException{
		pizzaDao.deleteItem(code);
	}
}
