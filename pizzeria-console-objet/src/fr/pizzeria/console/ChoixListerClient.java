/**
 * 28 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.List;

import fr.pizzeria.dao.IItemDao;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.model.AbstractPersonne;
import fr.pizzeria.model.Client;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChoixListerClient extends Choix<String, Client> {
	
	

	/**
	 * @param numeroChoix
	 * @param nomChoix
	 * @param dao
	 */
	public ChoixListerClient(Integer numeroChoix, String nomChoix, IItemDao<String, Client> dao) {
		super(numeroChoix, nomChoix, dao);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihmtools.Choix#faireUneAction()
	 */
	@Override
	public Boolean faireUneAction() {
		List<Client> lesClients = this.getItemDao().findAllItems();
		return true;
	}

}
