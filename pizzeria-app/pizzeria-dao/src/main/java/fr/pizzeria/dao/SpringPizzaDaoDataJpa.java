/**
 * 30 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.pizzeria.dao.annotation.DaoSource;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaValidator;

/**
 * @author Christopher CHARLERY
 *
 */
@Repository
@DaoSource
public class SpringPizzaDaoDataJpa implements ItemDao<String, Pizza> {
	
	@Autowired private IPizzaRepository repository;
	private List<Pizza> pizzas;
	private PizzaValidator validator;
	
	/**
	 * 
	 */
	public SpringPizzaDaoDataJpa() {
		this.pizzas = new ArrayList<>();
		this.validator = new PizzaValidator();
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.ItemDao#getItems()
	 */
	@Override
	public List<Pizza> getItems() {
		return this.pizzas;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.ItemDao#findAllItems()
	 */
	@Override
	public void findAllItems() {
		this.pizzas.clear();
		this.repository.findAll().forEach(pizza -> this.pizzas.add(pizza));
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.ItemDao#find(java.lang.Object)
	 */
	@Override
	public Pizza find(String code) {
		return this.repository.findByCode(code).get(0);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.ItemDao#saveNewItem(java.lang.Object)
	 */
	@Override
	public void saveNewItem(Pizza item) {
		this.validator.verifySaisie(item);
		this.repository.save(item);
		this.pizzas.add(item);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.ItemDao#updateItem(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void updateItem(String index, Pizza item) {
		this.validator.verifyCode(index);
		this.validator.verifySaisie(item);
		Pizza pizza = this.repository.findByCode(index).get(0);
		item.setId(pizza.getId());
		this.repository.save(item);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.ItemDao#deleteItem(java.lang.Object)
	 */
	@Override
	public void deleteItem(String index) {
		this.validator.verifyCode(index);
		this.repository.delete(this.repository.findByCode(index).get(0));
	}

}
