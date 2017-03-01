/**
 * 24 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IClientDaoImpl;
import fr.pizzeria.dao.IItemDao;
import fr.pizzeria.dao.IPizzaDaoImpl;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.ihmtools.ChoixSortir;
import fr.pizzeria.ihmtools.Menu;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;



/**
 * @author Christopher CHARLERY
 *
 */
public class MenuPizzeria {

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
	
	//Lister les pizzas par catégorie
	private Choix<String, Pizza> listerCateg;
	
	//Affiche la pizza la plus chère
	private Choix<String, Pizza> afficherPizzaMAx;
	
	//Affiche la liste des clients
	private Choix<Integer, Client> listerClient;

	/**
	 * Crée un menu pizza
	 */
	public MenuPizzeria(Scanner scan) {
		IItemDao<String, Pizza> pizzaDao = new IPizzaDaoImpl();
		IItemDao<Integer, Client> clientDao = new IClientDaoImpl();
		
		this.menu = new Menu("***** Pizzeria Administration *****");
		
		this.lister = new ChoixListerPizza(1, "Lister les pizzas",pizzaDao);
		this.listerCateg = new ChoixListerCateg(2, "Lister les pizzas par catégories", pizzaDao);
		this.afficherPizzaMAx = new ChoixPizzaMax(3, "Afficher la pizza au tarif le plus élevé", pizzaDao, scan);
		this.ajouter = new ChoixAjouter(4, "Ajouter une nouvelle pizza", pizzaDao, scan);
		this.modifier = new ChoixModifier(5, "Mettre à jour une pizza", pizzaDao, scan);
		this.supprimer = new ChoixSupprimer(6, "Supprimer une pizza", pizzaDao, scan);
		this.listerClient = new ChoixListerClient(7, "Lister les clients", clientDao);
		this.sortir = new ChoixSortir(99, "Sortir", scan);
		
		this.menu.addChoix(this.lister);
		this.menu.addChoix(this.listerCateg);
		this.menu.addChoix(this.afficherPizzaMAx);
		this.menu.addChoix(this.ajouter);
		this.menu.addChoix(this.modifier);
		this.menu.addChoix(this.supprimer);
		this.menu.addChoix(this.listerClient);
		this.menu.addChoix(this.sortir);
	}

	

	/**
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}

}
