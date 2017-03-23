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
	
	/**
	 * Retourne une pizza spécifique
	 * @param code
	 * @return
	 */
	public Pizza findPizza(String code) {
		return this.pizzaDao.find(code);
	}
	
	/**
	 * Liste les pizzas
	 * @return
	 */
	public List<Pizza> findAllPizzas(){
		pizzaDao.findAllItems();
		return this.pizzaDao.getItems();
	}
	
	/**
	 * Ajoute une nouvelle pizza
	 * @param item
	 * @throws StockageException
	 */
	public void savePizza(Pizza item) throws StockageException{
		this.pizzaDao.saveNewItem(item);
	}
	
	/**
	 * Modifie une pizza
	 * @param ancienCode
	 * @param item
	 * @throws StockageException
	 */
	public void updatePizza(String ancienCode, Pizza item) throws StockageException{
		this.pizzaDao.updateItem(ancienCode, item);
	}
	
	/**
	 * Supprime une pizza
	 * @param code
	 * @throws StockageException
	 */
	public void deletePizza(String code) throws StockageException{
		this.pizzaDao.deleteItem(code);
	}
}
