/**
 * 24 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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
		while (!saisieOk) {
			try {
				Map<Integer, CategoriePizza> categories = new TreeMap<Integer, CategoriePizza>();
				categories.put(1, CategoriePizza.POISSON);
				categories.put(2, CategoriePizza.SANS_VIANDE);
				categories.put(3, CategoriePizza.VIANDE);

				System.out.print("Veuillez saisir le code : ");
				String codePizza = this.getSc().nextLine().toUpperCase();
				System.out.print("Veuillez saisir le nom (sans espace) : ");
				String nomPizza = this.getSc().nextLine();
				System.out.print("Veuillez saisir le prix : ");
				Double prixPizza = Double.parseDouble(this.getSc().nextLine());

				System.out.println("Veuillez choisir la catégorie de la pizza : ");
				categories.forEach((id, categorie) -> {
					System.out.print(" / " + id + ". " + categorie.toString());
				});
				System.out.println();
				Integer idCategorie = Integer.parseInt(this.getSc().nextLine());

				this.getItemDao().saveNewItem(new Pizza(0, codePizza, nomPizza, prixPizza, categories.get(idCategorie)));
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