/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IItemDao;
import fr.pizzeria.dao.IPizzaDaoImpl;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzeriaAdminConsoleApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String readline = "";
		Scanner sc = new Scanner(System.in);
		Integer choice;
		IItemDao<String, Pizza> pizzaDao = new IPizzaDaoImpl();
		MenuPizza menuPizza = new MenuPizza(sc, pizzaDao);

		menuPizza.getMenu().show();
		readline = sc.nextLine();
		choice = Integer.parseInt(readline);
		Boolean continuer = true;
		while (continuer) {
			continuer = menuPizza.getMenu().appliquerChoix(choice);
			if (continuer) {
				menuPizza.getMenu().show();
				readline = sc.nextLine();
				choice = Integer.parseInt(readline);
			}
		}
	}
}
