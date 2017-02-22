/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.dao.IPizzaDaoImpl;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzeriaAdminConsoleApp {

	private static String readline = "";
	static Scanner sc = new Scanner(System.in);
	private static Integer choice;
	private static Menu menu = new Menu(100);
	private static IPizzaDaoImpl pizzaDao = new IPizzaDaoImpl(100);	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		pizzaDao.initializeArray();
		
		//Lister les pizzas
		Choix lister = new ChoixLister(1, "Lister les pizzas");
		menu.addChoix(lister);

		//Ajouter une pizza
		Choix ajouter = new ChoixAjouter(2, "Ajouter une nouvelle pizza");
		menu.addChoix(ajouter);

		//Modifier une pizza
		Choix modifier = new ChoixModifier(3, "Mettre à jour une pizza");
		menu.addChoix(modifier);

		//Supprimer une pizza
		Choix supprimer = new ChoixSupprimer(4, "Supprimer une pizza");
		menu.addChoix(supprimer);
		
		//Sortir de l'application
		Choix sortir = new Choix(99, "Sortir") {
			@Override
			public void faireUneAction(Integer num, IPizzaDaoImpl pizzaDao, Scanner sc) {		
			}		
		};
		menu.addChoix(sortir);

		menu.show();
		readline = sc.nextLine();
		choice = Integer.parseInt(readline);

		//Tant que l'utilisateur n'a pas saisi 99
		while (choice != 99) {
			appliquerChoix(choice, lister);
			appliquerChoix(choice, ajouter);
			appliquerChoix(choice, modifier);
			appliquerChoix(choice, supprimer);
			menu.show();
			readline = sc.nextLine();
			choice = Integer.parseInt(readline);
		}
		sc.close();
	}

	/**
	 * Effectue l'action liée au choix si le numero correspond à celui du choix
	 * @param numero
	 * @param unChoix
	 */
	private static void appliquerChoix(Integer numero, Choix unChoix) {
		unChoix.faireUneAction(numero, pizzaDao, sc);
	}


}
