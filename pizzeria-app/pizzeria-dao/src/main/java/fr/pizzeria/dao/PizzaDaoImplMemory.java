/**
 * 6 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzaDaoImplMemory implements ItemDao<String, Pizza> {
	
	private List<Pizza> pizzas;
	
	/**
	 * Crée un dao pour une implémentation en memoire des pizzas
	 */
	public PizzaDaoImplMemory() {
		this.pizzas = new ArrayList<>();
		initializeList();
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.ItemDao#findAllItems()
	 */
	@Override
	public List<Pizza> findAllItems() {
		return this.pizzas;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.ItemDao#initializeList()
	 */
	@Override
	public void initializeList() {
		Pizza peperoni = new Pizza(null, "PEP", "Pépéroni", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE);
		this.pizzas.add(peperoni);

		Pizza margherita = new Pizza(null, "MAR", "Margherita", BigDecimal.valueOf(14.00), CategoriePizza.VEGETARIENNE);
		this.pizzas.add(margherita);

		Pizza laReine = new Pizza(null, "REI", "La Reine", BigDecimal.valueOf(11.50), CategoriePizza.VIANDE);
		this.pizzas.add(laReine);

		Pizza la4Fromages = new Pizza(null, "FRO", "La 4 fromages", BigDecimal.valueOf(12.00), CategoriePizza.VEGETARIENNE);
		this.pizzas.add(la4Fromages);

		Pizza laCannibale = new Pizza(null, "CAN", "La cannibale", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE);
		this.pizzas.add(laCannibale);

		Pizza laSavoyarde = new Pizza(null, "SAV", "La savoyarde", BigDecimal.valueOf(13.00), CategoriePizza.VIANDE);
		this.pizzas.add(laSavoyarde);

		Pizza lOrientale = new Pizza(null, "ORI", "L'orientale", BigDecimal.valueOf(13.50), CategoriePizza.VIANDE);
		this.pizzas.add(lOrientale);

		Pizza lIndienne = new Pizza(null, "IND", "L'indienne", BigDecimal.valueOf(14.00), CategoriePizza.VIANDE);
		this.pizzas.add(lIndienne);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.ItemDao#saveNewItem(java.lang.Object)
	 */
	@Override
	public void saveNewItem(Pizza pizza) throws StockageException {
		if (pizza.getCode() == null || "".equalsIgnoreCase(pizza.getCode())) {
			throw new StockageException("Le code de la pizza est incorrect !");
		}
		if (pizza.getNom() == null || "".equalsIgnoreCase(pizza.getNom())) {
			throw new StockageException("Le nom de la pizza est incorrect !");
		}
		if (pizza.getCategorie() == null) {
			throw new StockageException("Vous devez choisir une catégorie de pizza !");
		}
		this.pizzas.add(pizza);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.ItemDao#updateItem(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void updateItem(String codePizza, Pizza pizza) throws StockageException {
		if (codePizza == null || "".equalsIgnoreCase(codePizza)) {
			throw new StockageException("Le code de la pizza sélectionnée est incorrect !");
		}
		if (pizza.getCode() == null || "".equalsIgnoreCase(pizza.getCode())) {
			throw new StockageException("Le code modifié de la pizza est incorrect !");
		}
		if (pizza.getNom() == null || "".equalsIgnoreCase(pizza.getNom())) {
			throw new StockageException("Le nom modifié de la pizza est incorrect !");
		}

		Optional<Pizza> optPizza = this.pizzas.stream().filter(laPizza -> codePizza.equalsIgnoreCase(laPizza.getCode()))
				.findFirst();

		if (optPizza.isPresent()) {
			this.pizzas.set(this.pizzas.indexOf(optPizza.get()), pizza);
		} else {
			throw new StockageException("Pizza introuvable ! Veuillez renseigner une pizza dans la liste !");
		}
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.ItemDao#deleteItem(java.lang.Object)
	 */
	@Override
	public void deleteItem(String codePizza) throws StockageException {
		if (codePizza == null || "".equalsIgnoreCase(codePizza)) {
			throw new StockageException("Le code de la pizza sélectionnée est incorrect !");
		}

		Optional<Pizza> optPizza = this.pizzas.stream().filter(laPizza -> codePizza.equalsIgnoreCase(laPizza.getCode()))
				.findFirst();

		if (optPizza.isPresent()) {
			this.pizzas.remove(optPizza.get());
		} else {
			throw new StockageException("Pizza introuvable ! Veuillez renseigner une pizza dans la liste !");
		}
	}
}
