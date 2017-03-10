/**
 * 10 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.dao.PizzaDaoImplDB;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChoixImporterPizzas extends Choix<String, Pizza> {

	/**
	 * @param numeroChoix
	 * @param nomChoix
	 * @param dao
	 * @param scan
	 */
	public ChoixImporterPizzas(Integer numeroChoix, String nomChoix, ItemDao<String, Pizza> dao, Scanner scan) {
		super(numeroChoix, nomChoix, dao, scan);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihmtools.Choix#faireUneAction()
	 */
	@Override
	public Boolean faireUneAction() {
		((PizzaDaoImplDB)this.getItemDao()).importPizzas();
		return true;
	}

}
