/**
 * 24 f�vr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.ihmtools.Menu;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class MenuPizzeria {

	private Menu menu;
	private Scanner scan;

	// Lister les pizzas
	private Choix<String, Pizza> lister;

	// Ajouter une pizza
	private Choix<String, Pizza> ajouter;

	// Modifier une pizza
	private Choix<String, Pizza> modifier;

	// Supprimer une pizza
	private Choix<String, Pizza> supprimer;

	// Sortir de l'application
	private Choix<String, Pizza> sortir;

	// Lister les pizzas par cat�gorie
	private Choix<String, Pizza> listerCateg;

	// Affiche la pizza la plus ch�re
	private Choix<String, Pizza> afficherPizzaMAx;

	// Affiche la liste des clients
	private Choix<Integer, Client> listerClient;

	private Choix<String, Pizza> importerPizzas;

	/**
	 * Crée un menu pizza
	 * 
	 * @param scan
	 *            Scanner utilisé dans toute l'application
	 */
	public MenuPizzeria(Scanner scanner, Menu menu) {
		this.scan = scanner;
		this.menu = menu;
	}

	/**
	 * Affiche le menu de la pizzeria
	 */
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
				this.getMenu().show();
				readline = this.scan.nextLine();
				choice = Integer.parseInt(readline);
			}
		}
	}
	
	/**
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}
	
	/**
	 * @param menu
	 *            the menu to set
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
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
	 * @return the ajouter
	 */
	public Choix<String, Pizza> getAjouter() {
		return ajouter;
	}

	/**
	 * @param ajouter
	 *            the ajouter to set
	 */
	public void setAjouter(Choix<String, Pizza> ajouter) {
		this.ajouter = ajouter;
	}

	/**
	 * @return the modifier
	 */
	public Choix<String, Pizza> getModifier() {
		return modifier;
	}

	/**
	 * @param modifier
	 *            the modifier to set
	 */
	public void setModifier(Choix<String, Pizza> modifier) {
		this.modifier = modifier;
	}

	/**
	 * @return the supprimer
	 */
	public Choix<String, Pizza> getSupprimer() {
		return supprimer;
	}

	/**
	 * @param supprimer
	 *            the supprimer to set
	 */
	public void setSupprimer(Choix<String, Pizza> supprimer) {
		this.supprimer = supprimer;
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
	 * @return the listerClient
	 */
	public Choix<Integer, Client> getListerClient() {
		return listerClient;
	}

	/**
	 * @param listerClient
	 *            the listerClient to set
	 */
	public void setListerClient(Choix<Integer, Client> listerClient) {
		this.listerClient = listerClient;
	}

	/**
	 * @return the importerPizzas
	 */
	public Choix<String, Pizza> getImporterPizzas() {
		return importerPizzas;
	}

	/**
	 * @param importerPizzas
	 *            the importerPizzas to set
	 */
	public void setImporterPizzas(Choix<String, Pizza> importerPizzas) {
		this.importerPizzas = importerPizzas;
	}

}
