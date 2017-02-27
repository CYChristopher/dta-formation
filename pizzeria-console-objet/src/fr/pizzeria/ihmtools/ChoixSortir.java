/**
 * 24 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihmtools;

import java.util.Scanner;

/**
 * @author Christopher CHARLERY
 *
 */
public final class ChoixSortir extends Choix {
	
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 */
	public ChoixSortir(Integer numeroChoix, String nomChoix, Scanner sc) {
		super(numeroChoix, nomChoix, sc);
	}

	@Override
	public Boolean faireUneAction() {
		System.out.println("Au revoir :)");
		this.getSc().close();
		return false;
	}
}