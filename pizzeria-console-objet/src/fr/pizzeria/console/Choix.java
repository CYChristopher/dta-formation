/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDaoImpl;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public abstract class Choix {
	
	private Integer numeroChoix;
	private String nomChoix;
	
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 */
	public Choix(Integer numeroChoix, String nomChoix) {
		super();
		this.numeroChoix = numeroChoix;
		this.nomChoix = nomChoix;
	}

	public abstract void faireUneAction(Integer num, IPizzaDaoImpl pizzaDao, Scanner sc);
	
	/**
	 * Liste les pizzas
	 */
	static void listPizzas(Pizza[] pizzas) {
		for (int i = 1; i <= pizzas.length - 1; i++) {
			// Si la ligne n'est pas vide
			if (pizzas[i] != null ) {
				System.out.println(pizzas[i].getCode() + " -> " + pizzas[i].getNom() + " (" + pizzas[i].getPrix() + " €)");
			}
		}
	}	

	/**
	 * @return the numeroChoix
	 */
	public int getNumeroChoix() {
		return numeroChoix;
	}

	/**
	 * @param numeroChoix the numeroChoix to set
	 */
	public void setNumeroChoix(Integer numeroChoix) {
		this.numeroChoix = numeroChoix;
	}

	/**
	 * @return the nomChoix
	 */
	public String getNomChoix() {
		return nomChoix;
	}

	/**
	 * @param nomChoix the nomChoix to set
	 */
	public void setNomChoix(String nomChoix) {
		this.nomChoix = nomChoix;
	}
}
