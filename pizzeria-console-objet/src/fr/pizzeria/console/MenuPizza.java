/**
 * 24 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IItemDao;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.ihmtools.ChoixSortir;
import fr.pizzeria.ihmtools.Menu;
import fr.pizzeria.model.Pizza;



/**
 * @author Christopher CHARLERY
 *
 */
public class MenuPizza {

	private Menu menu;

	// Lister les pizzas
	private Choix<String, Pizza> lister;

	//Ajouter une pizza
	private Choix<String, Pizza> ajouter;

	// Modifier une pizza
	private Choix<String, Pizza> modifier;

	// Supprimer une pizza
	private Choix<String, Pizza> supprimer;

	// Sortir de l'application
	private Choix<String, Pizza> sortir;

	/**
	 * Crée un menu pizza
	 */
	public MenuPizza(Scanner scan, IItemDao<String, Pizza> dao) {
		this.menu = new Menu("***** Pizzeria Administration V2 *****");
		
		this.lister = new ChoixLister(1, "Lister les pizzas",dao);
		this.ajouter = new ChoixAjouter(2, "Ajouter une nouvelle pizza", dao, scan);
		this.modifier = new ChoixModifier(3, "Mettre à jour une pizza", dao, scan);
		this.supprimer = new ChoixSupprimer(4, "Supprimer une pizza", dao, scan);
		this.sortir = new ChoixSortir(99, "Sortir", scan);
		
		this.menu.addChoix(this.lister);
		this.menu.addChoix(this.ajouter);
		this.menu.addChoix(this.modifier);
		this.menu.addChoix(this.supprimer);
		this.menu.addChoix(this.sortir);
	}

	

	/**
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}

}
