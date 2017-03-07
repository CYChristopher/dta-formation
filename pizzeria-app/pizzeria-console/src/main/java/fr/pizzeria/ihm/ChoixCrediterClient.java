/**
 * 1 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.ihmtools.Tools;
import fr.pizzeria.model.Client;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChoixCrediterClient extends Choix<Integer, Client> {

	/**
	 * @param numeroChoix
	 * @param nomChoix
	 * @param dao
	 * @param scan
	 */
	public ChoixCrediterClient(Integer numeroChoix, String nomChoix, ItemDao<Integer, Client> dao, Scanner scan) {
		super(numeroChoix, nomChoix, dao, scan);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihmtools.Choix#faireUneAction()
	 */
	@Override
	public Boolean faireUneAction() {
		List<Client> lesClients = this.getItemDao().findAllItems();
		new Tools().listClients(lesClients);
		System.out.print("Veuillez selectionner l'identifiant d'un client : ");
		// Integer idChoisi = Integer.parseInt(this.getSc().nextLine());
		
		return null;
	}

}
