/**
 * 28 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.model.AbstractPersonne;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChoixListerClient extends Choix<String, AbstractPersonne> {
	
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 */
	public ChoixListerClient(Integer numeroChoix, String nomChoix) {
		super(numeroChoix, nomChoix);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihmtools.Choix#faireUneAction()
	 */
	@Override
	public Boolean faireUneAction() {
		return true;
	}

}
