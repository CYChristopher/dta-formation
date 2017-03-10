/**
 * 10 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class DaoPizzaTools {

	/**
	 * @param pizza
	 * @throws StockageException
	 */
	public void verifySaisie(Pizza pizza) throws StockageException {
		if (pizza.getCode() == null || "".equalsIgnoreCase(pizza.getCode())) {
			throw new StockageException("Le code de la pizza est incorrect !");
		}
		if (pizza.getNom() == null || "".equalsIgnoreCase(pizza.getNom())) {
			throw new StockageException("Le nom de la pizza est incorrect !");
		}
		if (pizza.getCategorie() == null) {
			throw new StockageException("Vous devez choisir une catégorie de pizza !");
		}
	}
	
	/**
	 * @param codePizza
	 * @throws StockageException
	 */
	public void verifyCode(String codePizza) throws StockageException {
		if (codePizza == null || "".equalsIgnoreCase(codePizza)) {
			throw new StockageException("Le code de la pizza sélectionnée est incorrect !");
		}
	}
}
