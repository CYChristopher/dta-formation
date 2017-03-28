/**
 * 24 Férvier 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.ihmtools.Tools;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public final class ChoixSupprimer extends Choix<String, Pizza> {
	
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 */
	public ChoixSupprimer(Integer numeroChoix, String nomChoix, ItemDao<String, Pizza> pizzaDao, Scanner scan) {
		super(numeroChoix, nomChoix, pizzaDao, scan);
	}

	@Override
	public Boolean faireUneAction() {
		Boolean saisieOk = false;
		String codeSaisiS = "";
		while (!saisieOk && !"99".equalsIgnoreCase(codeSaisiS)) {
			try {
				List<Pizza> lesPizzas = this.getItemDao().getItems();
				new Tools().listPizzas(lesPizzas);
				System.out.print("Veuillez choisir la pizza à supprimer (99 pour abandonner): ");
				codeSaisiS = this.getSc().nextLine();
				if (!"99".equalsIgnoreCase(codeSaisiS) && lesPizzas.size() < 99) {
					this.getItemDao().deleteItem(codeSaisiS);
					saisieOk = true;
				} else {
					System.out.println("Aucune pizza supprimée.");
					saisieOk = true;
				}
				System.out.println();
			} catch (StockageException e) {
				Logger myLogger = Logger.getLogger(this.getClass().getName());
				myLogger.log(Level.WARNING, e.getMessage(), e);
				System.out.print("Tapez 99 si vous voulez abandonner, n'importe quoi pour continuer :");
				String choix = this.getSc().nextLine();
				if (choix != null && "99".equalsIgnoreCase(choix)) {
					saisieOk = true;
				}
			}
		}
		return true;
	}
}