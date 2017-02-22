/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDaoImpl;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public final class ChoixLister extends Choix {
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 */
	public ChoixLister(Integer numeroChoix, String nomChoix) {
		super(numeroChoix, nomChoix);
	}

	@Override
	public void faireUneAction(Integer num, IPizzaDaoImpl pizzaDao, Scanner sc) {
		if (num == this.getNumeroChoix()) {
			listPizzas(pizzaDao.findAllPizzas());
			System.out.println("-> " + Pizza.getNbPizzas() + " pizzas dans le menu");
			System.out.println();
		}
	}
}