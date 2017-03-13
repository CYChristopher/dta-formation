/**
 * 27 f�vr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

/**
 * @author Christopher CHARLERY
 *
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractPersonne {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 255, nullable = false)
	private String nom;
	@Column(length = 255, nullable = false)
	private String prenom;
	@Column(length = 255, nullable = true)
	private String adresse;
	@Column(length = 255, nullable = true)
	private String telephone;
	private BigDecimal solde;
	
	/**
	 * 
	 */
	public AbstractPersonne() {
		//Constructeur par default
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param solde
	 */
	public AbstractPersonne(Integer id, String nom, String prenom, BigDecimal solde) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.solde = solde;
	}

	/**
	 * 
	 * @param montant
	 * @throws CreditException
	 */
	public void crediterCompte(BigDecimal montant) throws CreditException {
		this.solde.add(montant);
		if (this.solde.intValue() > 5000) {
			throw new CreditException("Vous ne pouvez depasser le seuil maximum qui est de 5 000 euros !");
		}
	}

	/**
	 * 
	 * @param montant
	 * @throws DebitException
	 */
	public void debiterCompte(BigDecimal montant) throws DebitException {
		this.solde.subtract(montant);
		if (this.solde.intValue() < 0) {
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
	public BigDecimal getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}

}
