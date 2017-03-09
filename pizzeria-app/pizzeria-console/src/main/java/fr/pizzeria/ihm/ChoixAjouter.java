/**
 * 24 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.ItemDao;
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
	public ChoixAjouter(Integer numeroChoix, String nomChoix, ItemDao<String, Pizza> pizzaDao, Scanner scan) {
		super(numeroChoix, nomChoix, pizzaDao, scan);
	}

	@Override
	public Boolean faireUneAction() {
		Boolean saisieOk = false;
		Logger myLogger = Logger.getLogger(this.getClass().getName());
		while (!saisieOk) {
			try {
				Map<Integer, CategoriePizza> categories = new TreeMap<>();
				categories.put(1, CategoriePizza.POISSON);
				categories.put(2, CategoriePizza.VEGETARIENNE);
				categories.put(3, CategoriePizza.VIANDE);
				categories.put(4, CategoriePizza.FROMAGE);

				System.out.print("Veuillez saisir le code : ");
				String codePizza = this.getSc().nextLine().toUpperCase();
				System.out.print("Veuillez saisir le nom (sans espace) : ");
				String nomPizza = this.getSc().nextLine();
				System.out.print("Veuillez saisir le prix : ");
				BigDecimal prixPizza = BigDecimal.valueOf(Double.parseDouble(this.getSc().nextLine()));

				System.out.println("Veuillez choisir la catégorie de la pizza : ");
				categories.forEach((id, categorie) -> System.out.print(" / " + id + ". " + categorie.toString()));
				System.out.println();
				Integer idCategorie = Integer.parseInt(this.getSc().nextLine());

				this.getItemDao()
						.saveNewItem(new Pizza(codePizza, nomPizza, null, prixPizza, categories.get(idCategorie)));
				System.out.println();
				saisieOk = true;
			} catch (NumberFormatException e) {
				myLogger.log(Level.INFO, e.getMessage(), e);
			} catch (StockageException e) {
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