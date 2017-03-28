/**
 * 6 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaValidator;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzaDaoImplMemory implements ItemDao<String, Pizza> {

	private List<Pizza> pizzas;
	private DaoPizzaTools daoTools;
	private PizzaValidator validator;

	/**
	 * Crée un dao pour une implémentation en memoire des pizzas
	 */
	public PizzaDaoImplMemory() {
		this.pizzas = new ArrayList<>();
		this.daoTools = new DaoPizzaTools();
		this.validator = new PizzaValidator();
		findAllItems();
	}

	/**
	 * @return the pizzas
	 */
	@Override
	public List<Pizza> getItems() {
		return pizzas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#findAllItems()
	 */
	@Override
	public void findAllItems() {
		this.pizzas = this.daoTools.generatePizzas();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#saveNewItem(java.lang.Object)
	 */
	@Override
	public void saveNewItem(Pizza pizza){
		this.validator.verifySaisie(pizza);
		this.pizzas.add(pizza);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#updateItem(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public void updateItem(String codePizza, Pizza pizza){
		executeUpdate(codePizza, pizza, true);
	}

	/**
	 * @param codePizza
	 * @param pizza
	 * @param isUpdate
	 *            true si c'est une modification, false si c'est une suppression
	 * @throws StockageException
	 */
	private void executeUpdate(String codePizza, Pizza pizza, boolean isUpdate){
		this.validator.verifyCode(codePizza);
		Optional<Pizza> optPizza = this.pizzas.stream().filter(laPizza -> codePizza.equalsIgnoreCase(laPizza.getCode()))
				.findFirst();
		if (optPizza.isPresent()) {
			if (isUpdate) {
				this.validator.verifySaisie(pizza);
				this.pizzas.set(this.pizzas.indexOf(optPizza.get()), pizza);
			} else {
				this.pizzas.remove(optPizza.get());
			}
		} else {
			throw new StockageException("Pizza introuvable ! Veuillez renseigner une pizza dans la liste !");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#deleteItem(java.lang.Object)
	 */
	@Override
	public void deleteItem(String codePizza){
		executeUpdate(codePizza, null, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#find(java.lang.Object)
	 */
	@Override
	public Pizza find(String code) {
		return null;
	}
}
