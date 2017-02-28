/**
 * 27 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

/**
 * @author Christopher CHARLERY
 *
 */
public class Client {
	
	private Integer id;
	private String nom;
	private String prenom;
	private Double solde;
	
	public void crediterMontant(double montant) throws CreditException{
		this.solde += montant;
		if(this.solde > 5_000){
			throw new CreditException("Vous ne pouvez depasser le seuil maximum qui est de 5 000 € !");
		}
	}
	
	public void debiterMontant(double montant) throws DebitException{
		this.solde -= montant;
		if(this.solde < 0){
			throw new DebitException("Le solde ne peut être négatif !");
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.id + " -> " + this.prenom + " " + this.nom + " (" + this.solde + " €)";
	}

}
