/**
 * 24 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.ValidationException;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzaValidator {
	
	/**
	 * @param pizza
	 * @throws StockageException
	 */
	public void verifySaisie(Pizza pizza){
		if (pizza.getCode() == null || "".equalsIgnoreCase(pizza.getCode())) {
			throw new ValidationException("Le code de la pizza est incorrect !");
		}
		if (pizza.getNom() == null || "".equalsIgnoreCase(pizza.getNom())) {
			throw new ValidationException("Le nom de la pizza est incorrect !");
		}
		if (pizza.getCategorie() == null) {
			throw new ValidationException("Vous devez choisir une catégorie de pizza !");
		}
	}

	/**
	 * @param codePizza
	 * @throws StockageException
	 */
	public void verifyCode(String codePizza){
		if (codePizza == null || "".equalsIgnoreCase(codePizza)) {
			throw new ValidationException("Le code de la pizza sélectionnée est incorrect !");
		}
	}
	
}
