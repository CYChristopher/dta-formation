/**
 * 1 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Christopher CHARLERY
 *
 */
@Entity
public class Livreur extends AbstractPersonne implements CompteStat {

	@Column(name = "decouvert_autorise")
	private BigDecimal montantDecouvertAutorise;
	@OneToMany(mappedBy = "livreur")
	private List<Commande> commandes;
	
	/**
	 * 
	 */
	public Livreur() {
		super();
	}
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param solde
	 */
	public Livreur(Integer id, String nom, String prenom, BigDecimal solde) {
		super(id, nom, prenom, solde);
	}

	/**
	 * @return the montantDecouvertAutorise
	 */
	public BigDecimal getMontantDecouvertAutorise() {
		return montantDecouvertAutorise;
	}

	/**
	 * @param montantDecouvertAutorise the montantDecouvertAutorise to set
	 */
	public void setMontantDecouvertAutorise(BigDecimal montantDecouvertAutorise) {
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}

	/**
	 * @return the commandes
	 */
	public List<Commande> getCommandes() {
		return commandes;
	}

	/**
	 * @param commandes the commandes to set
	 */
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}	
}
