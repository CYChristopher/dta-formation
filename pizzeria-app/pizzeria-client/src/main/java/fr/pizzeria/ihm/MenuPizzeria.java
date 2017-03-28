/**
 * 24 f�vr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.ClientDaoImpl;
import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.exception.StockageException;
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

	// Sortir de l'application
	private Choix<String, Pizza> sortir;
	
	//Lister les pizzas par cat�gorie
	private Choix<String, Pizza> listerCateg;
	
	//Affiche la pizza la plus ch�re
	private Choix<String, Pizza> afficherPizzaMAx;

	/**
	 * Crée un menu pizza
	 * @param scan Scanner utilisé dans toute l'application
	 * @param pizzaDao Dao des pizza (varie en fonction de l(implémentation)
	 */
	public MenuPizzeria(Scanner scan, ItemDao<String, Pizza> pizzaDao) {
		if(pizzaDao == null){
			Logger myLogger = Logger.getLogger(this.getClass().getName());
			try {
				throw new StockageException("Impossible de charger la liste des pizzas !");
			} catch (StockageException e) {
				myLogger.log(Level.WARNING, e.getMessage(), e);
			}
		}
		
		this.menu = new Menu("***** Pizzeria Client *****");
		
		this.lister = new ChoixListerPizza(1, "Lister les pizzas",pizzaDao);
		this.listerCateg = new ChoixListerCateg(2, "Lister les pizzas par catégories", pizzaDao);
		this.afficherPizzaMAx = new ChoixPizzaMax(3, "Afficher la pizza au tarif le plus élevé", pizzaDao, scan);
		this.sortir = new ChoixSortir(99, "Sortir", scan);
		
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

}
