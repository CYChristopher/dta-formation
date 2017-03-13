/**
 * 13 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * @author Christopher CHARLERY
 *
 */
@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 255, nullable = false, unique = true)
	private String numero;
	@Column(length = 255, nullable = false)
	private String statut;
	@Transient
	private LocalDateTime date;
	@Column(precision = 10, scale = 2)
	private BigDecimal montant;
	@ManyToOne
	@JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
	private Client client;
	@ManyToOne
	@JoinColumn(name = "id_livreur", referencedColumnName = "id", nullable = false)
	private Livreur livreur;
	@OneToMany(mappedBy = "commande")
	private List<CommandeLigne> lignes;

	/**
	 * 
	 */
	public Commande() {
		// Constructeur par defaut
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the numeroCommande
	 */
	public String getNumeroCommande() {
		return numero;
	}

	/**
	 * @param numeroCommande
	 *            the numeroCommande to set
	 */
	public void setNumeroCommande(String numeroCommande) {
		this.numero = numeroCommande;
	}

	/**
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * @param statut
	 *            the statut to set
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

	/**
	 * @return the dateCommande
	 */
	public LocalDateTime getDateCommande() {
		return date;
	}

	/**
	 * @param dateCommande
	 *            the dateCommande to set
	 */
	public void setDateCommande(LocalDateTime dateCommande) {
		this.date = dateCommande;
	}

	/**
	 * @return the montant
	 */
	public BigDecimal getMontant() {
		return montant;
	}

	/**
	 * @param montant
	 *            the montant to set
	 */
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the livreur
	 */
	public Livreur getLivreur() {
		return livreur;
	}

	/**
	 * @param livreur the livreur to set
	 */
	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	/**
	 * @return the lignes
	 */
	public List<CommandeLigne> getLignes() {
		return lignes;
	}

	/**
	 * @param lignes the lignes to set
	 */
	public void setLignes(List<CommandeLigne> lignes) {
		this.lignes = lignes;
	}

	
}
