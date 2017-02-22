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
public final class ChoixAjouter extends Choix {
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 */
	public ChoixAjouter(Integer numeroChoix, String nomChoix) {
		super(numeroChoix, nomChoix);
	}

	@Override
	public void faireUneAction(Integer num, IPizzaDaoImpl pizzaDao, Scanner sc) {
		if (num == this.getNumeroChoix()) {
			System.out.print("Veuillez saisir le code : ");
			String codePizza = sc.nextLine();
			System.out.print("Veuillez saisir le nom (sans espace) : ");
			String nomPizza = sc.nextLine();
			System.out.print("Veuillez saisir le prix : ");
			Double prixPizza = Double.parseDouble(sc.nextLine());
			pizzaDao.saveNewPizza(new Pizza(0, codePizza, nomPizza, prixPizza));
			System.out.println();
		}
	}
}