/**
 * 23 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.admin.metier;

import java.time.ZonedDateTime;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import fr.pizzeria.admin.event.PizzaEvent;
import fr.pizzeria.admin.event.PizzaEventType;
import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzaService {
	@Inject private ItemDao<String, Pizza> pizzaDao;
	@Inject private Event<PizzaEvent> pizzaEvent;
	
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
		pizzaEvent.fire(new PizzaEvent(item, ZonedDateTime.now(), PizzaEventType.SAVE));
	}
	
	/**
	 * Modifie une pizza
	 * @param ancienCode
	 * @param item
	 * @throws StockageException
	 */
	public void updatePizza(String ancienCode, Pizza item) throws StockageException{
		Pizza pizza = findPizza(ancienCode);
		this.pizzaDao.updateItem(ancienCode, item);
		PizzaEvent event = new PizzaEvent(pizza, ZonedDateTime.now(), PizzaEventType.UPDATE);
		event.setModifiedPizza(item);
		pizzaEvent.fire(event);
	}
	
	/**
	 * Supprime une pizza
	 * @param code
	 * @throws StockageException
	 */
	public void deletePizza(String code) throws StockageException{
		Pizza pizza = findPizza(code);
		this.pizzaDao.deleteItem(code);
		pizzaEvent.fire(new PizzaEvent(pizza, ZonedDateTime.now(), PizzaEventType.DELETE));
	}
	
	
}
