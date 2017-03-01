/**
 * 1 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

/**
 * @author Christopher CHARLERY
 *
 */
public class Livreur extends AbstractPersonne implements CompteStat {

	private double montantDecouvertAutorise;
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param solde
	 */
	public Livreur(Integer id, String nom, String prenom, Double solde) {
		super(id, nom, prenom, solde);
	}

	/**
	 * @return the montantDecouvertAutorise
	 */
	public double getMontantDecouvertAutorise() {
		return montantDecouvertAutorise;
	}

	/**
	 * @param montantDecouvertAutorise the montantDecouvertAutorise to set
	 */
	public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}	
}
