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
public final class ChoixModifier extends Choix {
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 */
	public ChoixModifier(Integer numeroChoix, String nomChoix) {
		super(numeroChoix, nomChoix);
	}

	@Override
	public void faireUneAction(Integer num, IPizzaDaoImpl pizzaDao, Scanner sc) {
		if (num == this.getNumeroChoix()) {
			listPizzas(pizzaDao.findAllPizzas());
			System.out.print("Veuillez choisir la pizza à modifier (99 pour abandonner): ");
			String codeSaisi = sc.nextLine();
			if (!codeSaisi.equalsIgnoreCase("99") && Pizza.getNbPizzas() < 99) {
				System.out.print("Veuillez saisir le code : ");
				String codePizzaM = sc.nextLine();
				System.out.print("Veuillez saisir le nom (sans espace) : ");
				String nomPizzaM = sc.nextLine();
				System.out.print("Veuillez saisir le prix : ");
				Double prixPizzaM = Double.parseDouble(sc.nextLine());
				pizzaDao.updatePizza(codeSaisi, new Pizza(0, codePizzaM, nomPizzaM, prixPizzaM));
			}
			System.out.println();
		}

	}
}