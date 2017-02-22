/**
 * 22 f�vr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDaoImpl;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public final class ChoixSupprimer extends Choix {
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 */
	public ChoixSupprimer(Integer numeroChoix, String nomChoix) {
		super(numeroChoix, nomChoix);
	}

	@Override
	public void faireUneAction(Integer num, IPizzaDaoImpl pizzaDao, Scanner sc) {
		if (num == this.getNumeroChoix()) {
			listPizzas(pizzaDao.findAllPizzas());

			System.out.print("Veuillez choisir la pizza � supprimer (99 pour abandonner): ");
			String codeSaisiS = sc.nextLine();

			if (!codeSaisiS.equalsIgnoreCase("99") && Pizza.getNbPizzas() < 99) {
				pizzaDao.deletePizza(codeSaisiS);
			} else {
				System.out.println("Aucune pizza supprim�e.");
			}

			System.out.println();
		}
	}
}