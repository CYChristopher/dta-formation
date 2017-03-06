/**
 * 27 f�vr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

/**
 * @author Christopher CHARLERY
 *
 */
public abstract class AbstractPersonne {

	private Integer id;
	private String nom;
	private String prenom;
	private double solde;

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param solde
	 */
	public AbstractPersonne(Integer id, String nom, String prenom, Double solde) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.solde = solde;
	}

	public void crediterCompte(double montant) throws CreditException {
		this.solde += montant;
		if (this.solde > 5000) {
			throw new CreditException("Vous ne pouvez depasser le seuil maximum qui est de 5 000 euros !");
		}
	}

	public void debiterCompte(double montant) throws DebitException {
		this.solde -= montant;
		if (this.solde < 0) {
			throw new DebitException("Le solde ne peut être négatif !");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.id + " -> " + this.prenom + " " + this.nom + " (" + this.solde + " euros)";
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

}
