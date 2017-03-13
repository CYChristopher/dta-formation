/**
 * 13 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Embeddable
class LigneId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9211655010529386400L;
	
	
	@Column(name = "id_commande", nullable = false)
	private Integer idCommande;
	@Column(name = "id_pizza", nullable = false)
	private Integer idPizza;
	
	/**
	 * @return the commande
	 */
	public Integer getIdCommande() {
		return idCommande;
	}
	/**
	 * @param commande the commande to set
	 */
	public void setIdCommande(Integer commande) {
		this.idCommande = commande;
	}
	/**
	 * @return the pizza
	 */
	public Integer getPizza() {
		return idPizza;
	}
	/**
	 * @param pizza the pizza to set
	 */
	public void setPizza(Integer pizza) {
		this.idPizza = pizza;
	}	
}

/**
 * @author Christopher CHARLERY
 *
 */
@Entity
@Table(name = "commande_ligne")
public class CommandeLigne {

	@EmbeddedId
	private LigneId id;
	@ManyToOne
	@MapsId("idCommande")
	@JoinColumn(name = "id_commande", referencedColumnName = "id")
	private Commande commande;
	@ManyToOne
	@MapsId("idPizza")
	@JoinColumn(name = "id_pizza", referencedColumnName = "id")
	private Pizza pizza;
	@Column(name = "quantite")
	private Integer quantite;
	
	/**
	 * 
	 */
	public CommandeLigne() {
		// Constructeur par defaut
	}

	/**
	 * @return the commande
	 */
	public Commande getCommande() {
		return commande;
	}

	/**
	 * @param commande the commande to set
	 */
	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	/**
	 * @return the pizza
	 */
	public Pizza getPizza() {
		return pizza;
	}

	/**
	 * @param pizza the pizza to set
	 */
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	/**
	 * @return the quantite
	 */
	public Integer getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
}
