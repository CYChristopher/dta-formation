/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Choix;
import fr.pizzeria.model.Pizza;



/**
 * @author Christopher CHARLERY
 *
 */
public class PizzeriaAdminConsoleApp {

	private static String readline = "";
	private static Scanner sc = new Scanner(System.in);
	private static Integer choice;
	private static Pizza[] pizzas = new Pizza[100];
	private static Choix[] menu = new Choix[100];
	
	/**
	 * Ajoute un choix au menu
	 * @param choix
	 */
	private static void addChoix(Choix choix){
		for(int i = 0; i < menu.length; i++){
			if(menu[i] == null){
				menu[i] = choix;
				break;
			}
		}
	}

	/**
	 * Affiche le menu des pizzas
	 */
	private static void showMenu() {
		System.out.println("***** Pizzeria Administration V2 *****");
		for(int i = 0; i < menu.length; i++){
			if(menu[i] != null){
				System.out.println(menu[i].getNumeroChoix() + ". " + menu[i].getNomChoix());
			}
		}
	}

	/**
	 * Initialise le tableau des pizzas
	 */
	private static void initializeArray() {
		
		Pizza peperoni = new Pizza(0, "PEP", "Pépéroni", 12.50);
		pizzas[1] = peperoni;

		Pizza margherita = new Pizza(1, "MAR", "Margherita", 14.00);
		pizzas[2] = margherita;

		Pizza laReine = new Pizza(2, "REI", "La Reine", 11.50);
		pizzas[3] = laReine;

		Pizza la4Fromages = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		pizzas[4] = la4Fromages;

		Pizza laCannibale = new Pizza(4, "CAN", "La cannibale", 12.50);
		pizzas[5] = laCannibale;

		Pizza laSavoyarde = new Pizza(5, "SAV", "La savoyarde", 13.00);
		pizzas[6] = laSavoyarde;

		Pizza lOrientale = new Pizza(6, "ORI", "L'orientale", 13.50);
		pizzas[7] = lOrientale;

		Pizza lIndienne = new Pizza(7, "IND", "L'indienne", 14.00);
		pizzas[8] = lIndienne;

		Pizza.setNbPizzas(8);
	}

	/**
	 * Liste les pizzas
	 */
	private static void listPizzas() {
		for (int i = 1; i <= pizzas.length - 1; i++) {
			// Si la ligne n'est pas vide
			if (pizzas[i] != null ) {
				System.out.println(pizzas[i].getCode() + " -> " + pizzas[i].getNom() + " (" + pizzas[i].getPrix() + " €)");
			}
		}
		System.out.println("-> " + Pizza.getNbPizzas() + " pizzas dans le menu");
	}

	/**
	 * Modifie une pizza
	 * 
	 * @param codeSaisi
	 *            Code de la pizza à modifier
	 * @param codePizza
	 *            Nouveau code
	 * @param nomPizza
	 *            Nouveau nom
	 * @param prixPizza
	 *            Nouveau prix
	 */
	private static void modifyPizzas(Boolean isModif, String codeSaisi, String codePizza, String nomPizza, Double prixPizza) {
		for (int i = 1; i <= pizzas.length; i++) {
			if (pizzas[i] != null && pizzas[i].getCode().equalsIgnoreCase(codeSaisi)) {
				if(isModif){
					pizzas[i].setCode(codePizza);
					pizzas[i].setNom(nomPizza);
					pizzas[i].setPrix(prixPizza);
					break;
				}else {
					pizzas[i] = null;
					break;
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		initializeArray();

		//Lister les pizzas
		Choix lister = new Choix(1, "Lister les pizzas") {

			@Override
			public void faireUneAction(Integer num) {
				if (num == this.getNumeroChoix()) {
					listPizzas();
					System.out.println();
					showMenu();
				}
			}
		};
		addChoix(lister);

		//Ajouter une pizza
		Choix ajouter = new Choix(2, "Ajouter une nouvelle pizza") {

			@Override
			public void faireUneAction(Integer num) {
				if (num == this.getNumeroChoix()) {
					System.out.print("Veuillez saisir le code : ");
					String codePizza = sc.nextLine();
					System.out.print("Veuillez saisir le nom (sans espace) : ");
					String nomPizza = sc.nextLine();
					System.out.print("Veuillez saisir le prix : ");
					Double prixPizza = Double.parseDouble(sc.nextLine());

					for (int i = 1; i <= pizzas.length; i++) {
						if (pizzas[i] == null) {
							pizzas[i] = new Pizza(i, codePizza, nomPizza, prixPizza);
							Pizza.setNbPizzas(Pizza.getNbPizzas() + 1);
							break;
						}
					}

					System.out.println();
					showMenu();
				}
			}
		};
		addChoix(ajouter);

		//Modifier une pizza
		Choix modifier = new Choix(3, "Mettre à jour une pizza") {

			@Override
			public void faireUneAction(Integer num) {
				if (num == this.getNumeroChoix()) {
					listPizzas();

					System.out.print("Veuillez choisir la pizza à modifier (99 pour abandonner): ");
					String codeSaisi = sc.nextLine();
					if (!codeSaisi.equalsIgnoreCase("99") && Pizza.getNbPizzas() < 99) {

						System.out.print("Veuillez saisir le code : ");
						String codePizzaM = sc.nextLine();
						System.out.print("Veuillez saisir le nom (sans espace) : ");
						String nomPizzaM = sc.nextLine();
						System.out.print("Veuillez saisir le prix : ");
						Double prixPizzaM = Double.parseDouble(sc.nextLine());

						modifyPizzas(true, codeSaisi, codePizzaM, nomPizzaM, prixPizzaM);
					}

					System.out.println();
					showMenu();
				}

			}
		};
		addChoix(modifier);

		//Supprimer une pizza
		Choix supprimer = new Choix(4, "Supprimer une pizza") {

			@Override
			public void faireUneAction(Integer num) {
				if (num == this.getNumeroChoix()) {
					listPizzas();

					System.out.println("Veuillez choisir la pizza à supprimer (99 pour abandonner): ");
					String codeSaisiS = sc.nextLine();

					if (!codeSaisiS.equalsIgnoreCase("99") && Pizza.getNbPizzas() < 99) {
						modifyPizzas(false, codeSaisiS, "", "", 0.0);
						Pizza.setNbPizzas(Pizza.getNbPizzas() - 1);
					} else {
						System.out.println("Aucune pizza supprimée.");
					}

					System.out.println();
					showMenu();
				}
			}
		};
		addChoix(supprimer);
		
		//Sortir de l'application
		Choix sortir = new Choix(99, "Sortir") {
			
			@Override
			public void faireUneAction(Integer numeroChoix) {
			}
		};
		addChoix(sortir);

		showMenu();
		readline = sc.nextLine();
		choice = Integer.parseInt(readline);

		//Tant que l'utilisateur n'a pas saisi 99
		while (choice != 99) {
			appliquerChoix(choice, lister);
			appliquerChoix(choice, ajouter);
			appliquerChoix(choice, modifier);
			appliquerChoix(choice, supprimer);
			readline = sc.nextLine();
			choice = Integer.parseInt(readline);
		}

	}

	/**
	 * Effectue l'action liée au choix si le numero correspond à celui du choix
	 * @param numero
	 * @param unChoix
	 */
	private static void appliquerChoix(Integer numero, Choix unChoix) {
		unChoix.faireUneAction(numero);
	}


}
