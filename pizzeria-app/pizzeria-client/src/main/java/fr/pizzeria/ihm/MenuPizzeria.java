/**
 * 24 f�vr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.ihmtools.Menu;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
@Component
public class MenuPizzeria {

	@Autowired
	private Menu menu;
	@Autowired
	private Scanner scan;

	// Lister les pizzas
	@Autowired
	private Choix<String, Pizza> lister;

	// Sortir de l'application
	@Autowired
	private Choix<String, Pizza> sortir;

	// Lister les pizzas par cat�gorie
	@Autowired
	private Choix<String, Pizza> listerCateg;

	// Affiche la pizza la plus ch�re
	@Autowired
	private Choix<String, Pizza> afficherPizzaMAx;

	/**
	 * Crée un menu pizza
	 * 
	 * @param scan
	 *            Scanner utilisé dans toute l'application
	 * @param pizzaDao
	 *            Dao des pizza (varie en fonction de l(implémentation)
	 */
	public MenuPizzeria(Scanner scan) {
		this.scan = scan;
		this.menu.addChoix(this.lister);
		this.menu.addChoix(this.listerCateg);
		this.menu.addChoix(this.afficherPizzaMAx);
		this.menu.addChoix(this.sortir);
	}

	/**
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}

	public void display() {
		String readline;
		Integer choice;
		this.menu.show();
		readline = this.scan.nextLine();
		choice = Integer.parseInt(readline);
		Boolean continuer = true;
		while (continuer) {
			continuer = this.menu.appliquerChoix(choice);
			if (continuer) {
				this.menu.show();
				readline = this.scan.nextLine();
				choice = Integer.parseInt(readline);
			}
		}
	}

	/**
	 * @return the scan
	 */
	public Scanner getScan() {
		return scan;
	}

	/**
	 * @param scan
	 *            the scan to set
	 */
	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	/**
	 * @return the lister
	 */
	public Choix<String, Pizza> getLister() {
		return lister;
	}

	/**
	 * @param lister
	 *            the lister to set
	 */
	public void setLister(Choix<String, Pizza> lister) {
		this.lister = lister;
	}

	/**
	 * @return the sortir
	 */
	public Choix<String, Pizza> getSortir() {
		return sortir;
	}

	/**
	 * @param sortir
	 *            the sortir to set
	 */
	public void setSortir(Choix<String, Pizza> sortir) {
		this.sortir = sortir;
	}

	/**
	 * @return the listerCateg
	 */
	public Choix<String, Pizza> getListerCateg() {
		return listerCateg;
	}

	/**
	 * @param listerCateg
	 *            the listerCateg to set
	 */
	public void setListerCateg(Choix<String, Pizza> listerCateg) {
		this.listerCateg = listerCateg;
	}

	/**
	 * @return the afficherPizzaMAx
	 */
	public Choix<String, Pizza> getAfficherPizzaMAx() {
		return afficherPizzaMAx;
	}

	/**
	 * @param afficherPizzaMAx
	 *            the afficherPizzaMAx to set
	 */
	public void setAfficherPizzaMAx(Choix<String, Pizza> afficherPizzaMAx) {
		this.afficherPizzaMAx = afficherPizzaMAx;
	}

	/**
	 * @param menu
	 *            the menu to set
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
