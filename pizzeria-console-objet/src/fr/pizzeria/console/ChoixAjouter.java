/**
 * 24 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IItemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
final class ChoixAjouter extends Choix<String, Pizza> {
	
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 */
	public ChoixAjouter(Integer numeroChoix, String nomChoix, IItemDao<String, Pizza> pizzaDao, Scanner scan) {
		super(numeroChoix, nomChoix, pizzaDao, scan);
	}

	@Override
	public Boolean faireUneAction() {
		Boolean saisieOk = false;
		while (!saisieOk) {
			try {
				System.out.print("Veuillez saisir le code : ");
				String codePizza = this.getSc().nextLine();
				System.out.print("Veuillez saisir le nom (sans espace) : ");
				String nomPizza = this.getSc().nextLine();
				System.out.print("Veuillez saisir le prix : ");
				Double prixPizza = Double.parseDouble(this.getSc().nextLine());
				this.getItemDao().saveNewItem(new Pizza(0, codePizza, nomPizza, prixPizza, CategoriePizza.VIANDE));
				System.out.println();
				saisieOk = true;
			} catch (NumberFormatException e) {
				System.out.println("Le prix est incorrect !");
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