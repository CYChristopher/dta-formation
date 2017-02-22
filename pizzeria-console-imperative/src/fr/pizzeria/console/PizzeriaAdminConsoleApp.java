/**
 * 21 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzeriaAdminConsoleApp {

	private static String readline = "";
	private static Scanner sc = new Scanner(System.in);
	private static String[][] pizzas = new String[100][4];
	private static int nbPizzas;

	/**
	 * Affiche le menu des pizzas
	 */
	private static void showMenu() {
		System.out.println(
				"***** Pizzeria Administration *****\n 1. Lister les pizzas\n 2. Ajouter une nouvelle pizza\n 3. Mettre à jour une pizza\n 4. Supprimer une pizza\n 99. Sortir");
	}

	/**
	 * Initialise le tableau des pizzas
	 */
	private static void initializeArray() {
		pizzas[0][0] = "Index du tableau";
		pizzas[0][1] = "Code la pizza";
		pizzas[0][2] = "Nom";
		pizzas[0][3] = "Prix";

		// Pépéproni
		pizzas[1][0] = "0";
		pizzas[1][1] = "PEP";
		pizzas[1][2] = "Pépéroni";
		pizzas[1][3] = "12,50";

		// Margherita
		pizzas[2][0] = "1";
		pizzas[2][1] = "MAR";
		pizzas[2][2] = "Margherita";
		pizzas[2][3] = "14,00";

		// La Reine
		pizzas[3][0] = "2";
		pizzas[3][1] = "REI";
		pizzas[3][2] = "La Reine";
		pizzas[3][3] = "11,50";

		// La 4 fromages
		pizzas[4][0] = "3";
		pizzas[4][1] = "FRO";
		pizzas[4][2] = "La 4 Fromages";
		pizzas[4][3] = "12,00";

		// La cannibale
		pizzas[5][0] = "4";
		pizzas[5][1] = "CAN";
		pizzas[5][2] = "La cannibale";
		pizzas[5][3] = "12,50";

		// La savoyarde
		pizzas[6][0] = "5";
		pizzas[6][1] = "SAV";
		pizzas[6][2] = "La savoyarde";
		pizzas[6][3] = "13,00";

		// L'orientale
		pizzas[7][0] = "6";
		pizzas[7][1] = "ORI";
		pizzas[7][2] = "L'orientale";
		pizzas[7][3] = "13,50";

		// L'indienne
		pizzas[8][0] = "7";
		pizzas[8][1] = "IND";
		pizzas[8][2] = "L'indienne";
		pizzas[8][3] = "14,00";

		nbPizzas = 7;
	}

	/**
	 * Liste les pizzas
	 */
	private static void listPizzas() {
		for (int i = 1; i <= pizzas.length - 1; i++) {
			// Si la ligne n'est pas vide
			if (pizzas[i][1] != null && !pizzas[i][1].equals("")) {
				System.out.println(pizzas[i][1] + " -> " + pizzas[i][2] + " (" + pizzas[i][3] + " €)");
			}
		}
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
	private static void modifyPizzas(String codeSaisi, String codePizza, String nomPizza, String prixPizza) {
		for (int i = 1; i <= pizzas.length; i++) {
			if (pizzas[i][1].equalsIgnoreCase(codeSaisi)) {
				pizzas[i][1] = codePizza;
				pizzas[i][2] = nomPizza;
				pizzas[i][3] = prixPizza;
				break;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String readline = "";
		Scanner sc = new Scanner(System.in);
		int choice;

		initializeArray();

		showMenu();
		readline = sc.nextLine();
		choice = Integer.parseInt(readline);

		while (choice != 99) {
			switch (choice) {

			// Lister les pizzas
			case 1:
				listPizzas();
				System.out.println();
				showMenu();
				readline = sc.nextLine();
				choice = Integer.parseInt(readline);
				break;
			// Ajouter une pizza
			case 2:
				System.out.print("Veuillez saisir le code : ");
				String codePizza = sc.nextLine();
				System.out.print("Veuillez saisir le nom (sans espace) : ");
				String nomPizza = sc.nextLine();
				System.out.print("Veuillez saisir le prix : ");
				String prixPizza = sc.nextLine();

				for (int i = 1; i <= pizzas.length; i++) {
					if (pizzas[i][1] == null || pizzas[i][1].equalsIgnoreCase("")) {
						pizzas[i][0] = Integer.toString(i);
						pizzas[i][1] = codePizza;
						pizzas[i][2] = nomPizza;
						pizzas[i][3] = prixPizza;
						nbPizzas++;
						break;
					}
				}

				System.out.println();
				showMenu();
				readline = sc.nextLine();
				choice = Integer.parseInt(readline);
				break;
			// Modifier une pizza
			case 3:
				listPizzas();

				System.out.print("Veuillez choisir la pizza à modifier (99 pour abandonner): ");
				String codeSaisi = sc.nextLine();
				if (!codeSaisi.equalsIgnoreCase("99") && nbPizzas < 99) {

					System.out.print("Veuillez saisir le code : ");
					String codePizzaM = sc.nextLine();
					System.out.print("Veuillez saisir le nom (sans espace) : ");
					String nomPizzaM = sc.nextLine();
					System.out.print("Veuillez saisir le prix : ");
					String prixPizzaM = sc.nextLine();

					modifyPizzas(codeSaisi, codePizzaM, nomPizzaM, prixPizzaM);
				}

				System.out.println();
				showMenu();
				readline = sc.nextLine();
				choice = Integer.parseInt(readline);

				break;
			// Supprimer une pizza
			case 4:
				listPizzas();

				System.out.println("Veuillez choisir la pizza à supprimer (99 pour abandonner): ");
				String codeSaisiS = sc.nextLine();

				if (!codeSaisiS.equalsIgnoreCase("99") && nbPizzas < 99) {
					modifyPizzas(codeSaisiS, "", "", "");
					nbPizzas--;
				} else {
					System.out.println("Aucune pizza supprimée.");
				}

				System.out.println();
				showMenu();
				readline = sc.nextLine();
				choice = Integer.parseInt(readline);
				break;

			default:
				System.out.println("Veuillez choisir un choix parmi les numéros !");
				System.out.println();
				showMenu();
				readline = sc.nextLine();
				choice = Integer.parseInt(readline);
				break;
			}
		}

		System.out.println("Au revoir.");
	}

}
