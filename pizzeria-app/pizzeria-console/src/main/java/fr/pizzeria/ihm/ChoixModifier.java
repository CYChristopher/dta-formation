/**
 * 24 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.ihmtools.Tools;
import fr.pizzeria.model.CategoriePizza;
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
		while (!saisieOk && !codeSaisi.equalsIgnoreCase("99")) {
			try {
				List<Pizza> lesPizzas = this.getItemDao().findAllItems();
				new Tools().listPizzas(lesPizzas);
				System.out.print("Veuillez choisir la pizza à modifier (99 pour abandonner): ");
				codeSaisi = this.getSc().nextLine();
				if (!codeSaisi.equalsIgnoreCase("99") && lesPizzas.size() < 99) {
					System.out.print("Veuillez saisir le code : ");
					String codePizzaM = this.getSc().nextLine().toUpperCase();
					System.out.print("Veuillez saisir le nom (sans espace) : ");
					String nomPizzaM = this.getSc().nextLine();
					System.out.print("Veuillez saisir le prix : ");
					Double prixPizzaM = Double.parseDouble(this.getSc().nextLine());
					this.getItemDao().updateItem(codeSaisi, new Pizza(0, codePizzaM, nomPizzaM, prixPizzaM, CategoriePizza.VIANDE));
					saisieOk = true;
				}
				System.out.println();
			} catch (NumberFormatException e) {
				System.out.println("Le prix est incorrect !");
				System.out.println();
				System.out.print("Tapez 99 si vous voulez abandonner, n'importe quoi pour continuer :");
				String choix = this.getSc().nextLine();
				if (choix != null && choix.equalsIgnoreCase("99")) {
					saisieOk = true;
				}
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