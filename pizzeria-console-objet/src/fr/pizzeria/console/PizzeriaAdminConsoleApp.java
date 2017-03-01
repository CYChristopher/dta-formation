/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.ihm.MenuPizzeria;

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
		MenuPizzeria menuPizza = new MenuPizzeria(sc);

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
