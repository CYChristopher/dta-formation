/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class IPizzaDaoImpl implements IPizzaDao {

	private Pizza[] pizzas;

	public IPizzaDaoImpl(Integer taille) {
		this.pizzas = new Pizza[taille];
	}

	/**
	 * Initialise le tableau des pizzas
	 */
	public void initializeArray() {

		Pizza peperoni = new Pizza(0, "PEP", "Pépéroni", 12.50);
		this.pizzas[1] = peperoni;

		Pizza margherita = new Pizza(1, "MAR", "Margherita", 14.00);
		this.pizzas[2] = margherita;

		Pizza laReine = new Pizza(2, "REI", "La Reine", 11.50);
		this.pizzas[3] = laReine;

		Pizza la4Fromages = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		this.pizzas[4] = la4Fromages;

		Pizza laCannibale = new Pizza(4, "CAN", "La cannibale", 12.50);
		this.pizzas[5] = laCannibale;

		Pizza laSavoyarde = new Pizza(5, "SAV", "La savoyarde", 13.00);
		this.pizzas[6] = laSavoyarde;

		Pizza lOrientale = new Pizza(6, "ORI", "L'orientale", 13.50);
		this.pizzas[7] = lOrientale;

		Pizza lIndienne = new Pizza(7, "IND", "L'indienne", 14.00);
		this.pizzas[8] = lIndienne;

		Pizza.setNbPizzas(8);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IPizzaDao#findAllPizzas()
	 */
	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IPizzaDao#saveNewPizza(fr.pizzeria.model.Pizza)
	 */
	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException{
		if(pizza.getCode() == null || pizza.getCode().equalsIgnoreCase("")){
			throw new SavePizzaException("Le code de la pizza est incorrect !");
		}
		if(pizza.getNom() == null || pizza.getNom().equalsIgnoreCase("")){
			throw new SavePizzaException("Le nom de la pizza est incorrect !");
		}
		for (int i = 1; i <= pizzas.length; i++) {
			if (pizzas[i] == null) {
				pizza.setId(i);
				pizzas[i] = pizza;
				Pizza.setNbPizzas(Pizza.getNbPizzas() + 1);
				break;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IPizzaDao#updatePizza(java.lang.String,
	 * fr.pizzeria.model.Pizza)
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException{
		if(codePizza == null || codePizza.equalsIgnoreCase("")){
			throw new UpdatePizzaException("Le code de la pizza sélectionnée est incorrect !");
		}
		if(pizza.getCode() == null || pizza.getCode().equalsIgnoreCase("")){
			throw new UpdatePizzaException("Le code modifié de la pizza est incorrect !");
		}
		if(pizza.getNom() == null || pizza.getNom().equalsIgnoreCase("")){
			throw new UpdatePizzaException("Le nom modifié de la pizza est incorrect !");
		}
		Boolean pizzaInList = false;
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null && pizzas[i].getCode().equalsIgnoreCase(codePizza)) {
				pizzas[i].setCode(pizza.getCode());
				pizzas[i].setNom(pizza.getNom());
				pizzas[i].setPrix(pizza.getPrix());
				pizzaInList = true;
				break;
			}
		}
		if(!pizzaInList){
			throw new UpdatePizzaException("Pizza introuvable ! Veuillez renseigner une pizza dans la liste !");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IPizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException{
		if(codePizza == null || codePizza.equalsIgnoreCase("")){
			throw new DeletePizzaException("Le code de la pizza sélectionnée est incorrect !");
		}
		Boolean pizzaInList = false;
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null && pizzas[i].getCode().equalsIgnoreCase(codePizza)) {
				pizzas[i] = null;
				Pizza.setNbPizzas(Pizza.getNbPizzas() - 1);
				pizzaInList = true;
				break;
			}
		}
		if(!pizzaInList){
			throw new DeletePizzaException("Pizza introuvable ! Veuillez renseigner une pizza dans la liste !");
		}
	}

}
