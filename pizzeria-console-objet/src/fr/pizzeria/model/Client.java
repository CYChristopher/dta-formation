/**
 * 1 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

/**
 * @author Christopher CHARLERY
 *
 */
public class Client extends AbstractPersonne implements CompteStat{

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param solde
	 */
	public Client(Integer id, String nom, String prenom, Double solde) {
		super(id, nom, prenom, solde);
	}
}
