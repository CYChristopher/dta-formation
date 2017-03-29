/**
 * 24 février 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihmtools;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * @author Christopher CHARLERY
 *
 */
@Controller
public final class ChoixSortir extends Choix {
	
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 * @param sc
	 */
	public ChoixSortir(@Value("${sortir.num}") Integer numeroChoix, @Value("${sortir.nom}") String nomChoix, Scanner sc) {
		super(numeroChoix, nomChoix, sc);
	}

	@Override
	public Boolean faireUneAction() {
		System.out.println("Au revoir :)");
		this.getSc().close();
		return false;
	}
}