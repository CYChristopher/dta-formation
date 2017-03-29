/**
 * 13 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.model.Client;

/**
 * @author Christopher CHARLERY
 * @param <G>
 * @param <I>
 *
 */
@Controller
public class ChoixSInscrire<G, I> extends Choix<I, G> {

	/**
	 * @param numeroChoix
	 * @param nomChoix
	 * @param dao
	 * @param scan
	 */
	public ChoixSInscrire(Integer numeroChoix, String nomChoix, ItemDao<I, G> dao, Scanner scan) {
		super(numeroChoix, nomChoix, dao, scan);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihmtools.Choix#faireUneAction()
	 */
	@Override
	public Boolean faireUneAction() {
		System.out.print("Veuillez saisir un nom : ");
		String nom = this.getSc().nextLine();
		System.out.print("Veuillez saisir un prenom : ");
		String prenom = this.getSc().nextLine();
		System.out.print("Veuillez saisir l'email : ");
		String email = this.getSc().nextLine();
		System.out.print("Veuillez saisir le mot de passe : ");
		String mdp = DigestUtils.md5Hex(this.getSc().nextLine());
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setEmail(email);
		client.setPassword(mdp);
		return true;
	}

}
