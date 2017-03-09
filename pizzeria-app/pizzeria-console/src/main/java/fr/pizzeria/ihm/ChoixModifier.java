/**
 * 24 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.math.BigDecimal;
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
final class ChoixModifier extends Choix<String, Pizza> {
	
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 */
	public ChoixModifier(Integer numeroChoix, String nomChoix, ItemDao<String, Pizza> pizzaDao, Scanner scan) {
		super(numeroChoix, nomChoix, pizzaDao, scan);
	}

	@Override
	public Boolean faireUneAction() {
		Boolean saisieOk = false;
		String codeSaisi = "";
		Logger myLogger = Logger.getLogger(this.getClass().getName());
		while (!saisieOk && !"99".equalsIgnoreCase(codeSaisi)) {
			try {
				List<Pizza> lesPizzas = this.getItemDao().findAllItems();
				new Tools().listPizzas(lesPizzas);
				System.out.print("Veuillez choisir la pizza à modifier (99 pour abandonner): ");
				codeSaisi = this.getSc().nextLine();
				if (!"99".equalsIgnoreCase(codeSaisi) && lesPizzas.size() < 99) {
					System.out.print("Veuillez saisir le code : ");
					String codePizzaM = this.getSc().nextLine().toUpperCase();
					System.out.print("Veuillez saisir le nom (sans espace) : ");
					String nomPizzaM = this.getSc().nextLine();
					System.out.print("Veuillez saisir le prix : ");
					BigDecimal prixPizzaM = BigDecimal.valueOf(Double.parseDouble(this.getSc().nextLine()));
					this.getItemDao().updateItem(codeSaisi, new Pizza(codePizzaM, nomPizzaM, null, prixPizzaM));
					saisieOk = true;
				}
				System.out.println();
			} catch (NumberFormatException | StockageException e) {
				myLogger.log(Level.INFO, e.getMessage(), e);
				if(e.getClass().equals(NumberFormatException.class)){
					System.out.println("Le prix est incorrect !");
					System.out.println();
				}
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