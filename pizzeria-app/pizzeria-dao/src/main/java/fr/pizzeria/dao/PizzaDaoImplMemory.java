/**
 * 6 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzaDaoImplMemory implements ItemDao<String, Pizza> {
	
	private List<Pizza> pizzas;
	private Boolean pizzaInList = false;
	
	/**
	 * 
	 */
	public PizzaDaoImplMemory() {
		this.pizzas = new ArrayList<Pizza>();
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
		Pizza peperoni = new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE);
		this.pizzas.add(peperoni);

		Pizza margherita = new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.VIANDE);
		this.pizzas.add(margherita);

		Pizza laReine = new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.VIANDE);
		this.pizzas.add(laReine);

		Pizza la4Fromages = new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE);
		this.pizzas.add(la4Fromages);

		Pizza laCannibale = new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE);
		this.pizzas.add(laCannibale);

		Pizza laSavoyarde = new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE);
		this.pizzas.add(laSavoyarde);

		Pizza lOrientale = new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.VIANDE);
		this.pizzas.add(lOrientale);

		Pizza lIndienne = new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.VIANDE);
		this.pizzas.add(lIndienne);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.ItemDao#saveNewItem(java.lang.Object)
	 */
	@Override
	public void saveNewItem(Pizza pizza) throws StockageException {
		if (pizza.getCode() == null || pizza.getCode().equalsIgnoreCase("")) {
			throw new StockageException("Le code de la pizza est incorrect !");
		}
		if (pizza.getNom() == null || pizza.getNom().equalsIgnoreCase("")) {
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
		if (codePizza == null || codePizza.equalsIgnoreCase("")) {
			throw new StockageException("Le code de la pizza sélectionnée est incorrect !");
		}
		if (pizza.getCode() == null || pizza.getCode().equalsIgnoreCase("")) {
			throw new StockageException("Le code modifié de la pizza est incorrect !");
		}
		if (pizza.getNom() == null || pizza.getNom().equalsIgnoreCase("")) {
			throw new StockageException("Le nom modifié de la pizza est incorrect !");
		}
		pizzaInList = false;
		this.pizzas.forEach((laPizza) -> {
			if (laPizza.getCode().equalsIgnoreCase(codePizza)) {
				laPizza.setCode(pizza.getCode());
				laPizza.setNom(pizza.getNom());
				laPizza.setPrix(pizza.getPrix());
				pizzaInList = true;
			}
		});
		if (!pizzaInList) {
			throw new StockageException("Pizza introuvable ! Veuillez renseigner une pizza dans la liste !");
		}
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.ItemDao#deleteItem(java.lang.Object)
	 */
	@Override
	public void deleteItem(String codePizza) throws StockageException {
		if (codePizza == null || codePizza.equalsIgnoreCase("")) {
			throw new StockageException("Le code de la pizza sélectionnée est incorrect !");
		}
		pizzaInList = false;
		Iterator<Pizza> iterator = this.pizzas.iterator();
		while (iterator.hasNext()) {
			Pizza unePizza = iterator.next();
			if (unePizza.getCode().equalsIgnoreCase(codePizza)) {
				pizzas.remove(unePizza);
				pizzaInList = true;
				break;
			}
		}
		if (!pizzaInList) {
			throw new StockageException("Pizza introuvable ! Veuillez renseigner une pizza dans la liste !");
		}
	}
}
