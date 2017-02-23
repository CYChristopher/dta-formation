/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDaoImpl;
import fr.pizzeria.exception.StockageException;
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
			Boolean saisieOk = false;
			String codeSaisiS = "";
			while (!saisieOk && !codeSaisiS.equalsIgnoreCase("99")) {
				try {
					listPizzas(pizzaDao.findAllPizzas());
					System.out.print("Veuillez choisir la pizza à supprimer (99 pour abandonner): ");
					codeSaisiS = sc.nextLine();
					if (!codeSaisiS.equalsIgnoreCase("99") && Pizza.getNbPizzas() < 99) {
						pizzaDao.deletePizza(codeSaisiS);
					} else {
						System.out.println("Aucune pizza supprimée.");
					}
					System.out.println();
				} catch (StockageException e) {
					System.out.println(e.getMessage());
					System.out.println();
				}
			}
		}
	}
}