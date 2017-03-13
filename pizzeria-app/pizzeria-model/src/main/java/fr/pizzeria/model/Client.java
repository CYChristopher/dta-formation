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
public class Client extends AbstractPersonne implements CompteStat{

	@Column(length = 255, nullable = false)
	private String email;
	@Column(length = 255, nullable = false)
	private String password;
	@OneToMany(mappedBy = "client")
	private List<Commande> commandes;
	
	/**
	 * 
	 */
	public Client() {
		super();
	}
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param solde
	 */
	public Client(Integer id, String nom, String prenom, BigDecimal solde) {
		super(id, nom, prenom, solde);
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
