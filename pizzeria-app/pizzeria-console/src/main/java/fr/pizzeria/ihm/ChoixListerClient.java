/**
 * 28 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.ihmtools.Tools;
import fr.pizzeria.model.Client;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChoixListerClient extends Choix<Integer, Client> {
	
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 * @param clientDao
	 */
	public ChoixListerClient(Integer numeroChoix, String nomChoix, ItemDao<Integer, Client> clientDao) {
		super(numeroChoix, nomChoix, clientDao);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihmtools.Choix#faireUneAction()
	 */
	@Override
	public Boolean faireUneAction() {
		List<Client> lesClients = this.getItemDao().getItems();
		new Tools().listClients(lesClients);
		System.out.println();
		return true;
	}

}
