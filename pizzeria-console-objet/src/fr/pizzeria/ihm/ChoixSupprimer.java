/**
 * 24 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IItemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.ihmtools.Tools;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
final class ChoixSupprimer extends Choix<String, Pizza> {
	
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 */
	public ChoixSupprimer(Integer numeroChoix, String nomChoix, IItemDao<String, Pizza> pizzaDao, Scanner scan) {
		super(numeroChoix, nomChoix, pizzaDao, scan);
	}

	@Override
	public Boolean faireUneAction() {
		Boolean saisieOk = false;
		String codeSaisiS = "";
		while (!saisieOk && !codeSaisiS.equalsIgnoreCase("99")) {
			try {
				List<Pizza> lesPizzas = this.getItemDao().findAllItems();
				new Tools().listPizzas(lesPizzas);
				System.out.print("Veuillez choisir la pizza à supprimer (99 pour abandonner): ");
				codeSaisiS = this.getSc().nextLine();
				if (!codeSaisiS.equalsIgnoreCase("99") && lesPizzas.size() < 99) {
					this.getItemDao().deleteItem(codeSaisiS);
					saisieOk = true;
				} else {
					System.out.println("Aucune pizza supprimée.");
					saisieOk = true;
				}
				System.out.println();
			} catch (StockageException e) {
				System.out.println(e.getMessage());
				System.out.println();
				System.out.print("Tapez 99 si vous voulez abandonner, n'importe quoi pour continuer :");
				String choix = this.getSc().nextLine();
				if (choix != null && choix.equalsIgnoreCase("99")) {
					saisieOk = true;
				}
			}
		}
		return true;
	}
}