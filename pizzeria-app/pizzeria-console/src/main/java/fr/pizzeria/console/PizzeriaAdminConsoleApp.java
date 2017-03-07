/**
 * 22 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.ihm.MenuPizzeria;
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
		ItemDao<String, Pizza> instanceDaoImpl = null;
		ResourceBundle bundle = ResourceBundle.getBundle("application");
        String daoImpl = bundle.getString("service.impl");
        
        try {
        	instanceDaoImpl = (ItemDao<String, Pizza>) Class.forName(daoImpl).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		MenuPizzeria menuPizza = new MenuPizzeria(sc, instanceDaoImpl);

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
