/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class IPizzaDaoImpl implements IItemDao<String, Pizza> {

	private List<Pizza> pizzas;
	private Boolean pizzaInList = false;

	/**
	 * 
	 * @param taille
	 */
	public IPizzaDaoImpl() {
		this.pizzas = new ArrayList<Pizza>();
	}

	/**
	 * Initialise le tableau des pizzas
	 */
	public void initializeList() {

		Pizza peperoni = new Pizza(0, "PEP", "Pépéroni", 12.50);
		this.pizzas.add(peperoni);

		Pizza margherita = new Pizza(1, "MAR", "Margherita", 14.00);
		this.pizzas.add(margherita);

		Pizza laReine = new Pizza(2, "REI", "La Reine", 11.50);
		this.pizzas.add(laReine);

		Pizza la4Fromages = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		this.pizzas.add(la4Fromages);

		Pizza laCannibale = new Pizza(4, "CAN", "La cannibale", 12.50);
		this.pizzas.add(laCannibale);

		Pizza laSavoyarde = new Pizza(5, "SAV", "La savoyarde", 13.00);
		this.pizzas.add(laSavoyarde);

		Pizza lOrientale = new Pizza(6, "ORI", "L'orientale", 13.50);
		this.pizzas.add(lOrientale);

		Pizza lIndienne = new Pizza(7, "IND", "L'indienne", 14.00);
		this.pizzas.add(lIndienne);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllItems() {
		return pizzas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#saveNewPizza(fr.pizzeria.dao)
	 */
	@Override
	public void saveNewItem(Pizza pizza) throws StockageException{
		if(pizza.getCode() == null || pizza.getCode().equalsIgnoreCase("")){
			throw new StockageException("Le code de la pizza est incorrect !");
		}
		if(pizza.getNom() == null || pizza.getNom().equalsIgnoreCase("")){
			throw new StockageException("Le nom de la pizza est incorrect !");
		}
		this.pizzas.add(pizza);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#updatePizza(java.lang.String,
	 * fr.pizzeria.dao)
	 */
	@Override
	public void updateItem(String codePizza, Pizza pizza) throws StockageException{
		if(codePizza == null || codePizza.equalsIgnoreCase("")){
			throw new StockageException("Le code de la pizza sélectionnée est incorrect !");
		}
		if(pizza.getCode() == null || pizza.getCode().equalsIgnoreCase("")){
			throw new StockageException("Le code modifié de la pizza est incorrect !");
		}
		if(pizza.getNom() == null || pizza.getNom().equalsIgnoreCase("")){
			throw new StockageException("Le nom modifié de la pizza est incorrect !");
		}
		pizzaInList = false;
		this.pizzas.forEach(new Consumer<Pizza>() {
			@Override
			public void accept(Pizza laPizza) {
				if(laPizza.getCode().equalsIgnoreCase(codePizza)){
					laPizza.setCode(pizza.getCode());
					laPizza.setNom(pizza.getNom());
					laPizza.setPrix(pizza.getPrix());
					pizzaInList = true;
				}
			}
		});
		if(!pizzaInList){
			throw new StockageException("Pizza introuvable ! Veuillez renseigner une pizza dans la liste !");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#deletePizza(java.lang.String)
	 */
	@Override
	public void deleteItem(String codePizza) throws StockageException{
		if(codePizza == null || codePizza.equalsIgnoreCase("")){
			throw new StockageException("Le code de la pizza sélectionnée est incorrect !");
		}
		pizzaInList = false;
		this.pizzas.forEach(new Consumer<Pizza>() {
			@Override
			public void accept(Pizza laPizza) {
				pizzas.remove(laPizza);
				pizzaInList = true;
			}
		});
		if(!pizzaInList){
			throw new StockageException("Pizza introuvable ! Veuillez renseigner une pizza dans la liste !");
		}
	}

}
