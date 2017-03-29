/**
 * 22 f�vr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Christopher CHARLERY
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "findAll", query = "FROM Pizza"),
		@NamedQuery(name = "getByCode", query = "FROM Pizza WHERE Code=:code") })
public class Pizza{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 5, nullable = false, unique = true)
	private String code;
	@Column(length = 255, nullable = false)
	private String nom;
	@Column(length = 255, nullable = true)
	private String description;
	@Column(precision = 10, scale = 2)
	private BigDecimal prix;
	@Enumerated(EnumType.STRING)
	@Column(length = 255, nullable = false)
	private CategoriePizza categorie;
	@Column(name = "url_image", length = 255, nullable = true)
	private String urlImage;

	/**
	 * 
	 */
	public Pizza() {
		// Constructeur par defaut
	}

	/**
	 * @param code
	 * @param nom
	 */
	public Pizza(String code, String nom) {
		super();
		this.code = code;
		this.nom = nom;
	}

	/**
	 * @param code
	 * @param nom
	 * @param description
	 */
	public Pizza(String code, String nom, String description) {
		super();
		this.code = code;
		this.nom = nom;
		this.description = description;
	}

	/**
	 * @param code
	 * @param nom
	 * @param description
	 * @param prix
	 */
	public Pizza(String code, String nom, String description, BigDecimal prix) {
		this(code, nom, description);
		this.prix = prix;
	}

	/**
	 * @param code
	 * @param nom
	 * @param description
	 * @param prix
	 * @param categorie
	 */
	public Pizza(String code, String nom, String description, BigDecimal prix, String categorie) {
		this(code, nom, description, prix);
		this.setCategorie(categorie);
	}

	/**
	 * @param code
	 * @param nom
	 * @param description
	 * @param prix
	 * @param categorie
	 */
	public Pizza(String code, String nom, String description, BigDecimal prix, CategoriePizza categorie) {
		this(code, nom, description, prix);
		this.setCategorie(categorie);
	}

	/**
	 * @param id
	 * @param code
	 * @param nom
	 */
	public Pizza(Integer id, String code, String nom) {
		this(code, nom);
		this.id = id;
	}

	/**
	 * @param id
	 * @param code
	 * @param nom
	 * @param description
	 */
	public Pizza(Integer id, String code, String nom, String description) {
		this(id, code, nom);
		this.description = description;
	}

	/**
	 * @param id
	 * @param code
	 * @param nom
	 * @param description
	 * @param prix
	 */
	public Pizza(Integer id, String code, String nom, String description, BigDecimal prix) {
		this(id, code, nom, description);
		this.prix = prix;
	}
	
	/**
	 * @param id
	 * @param code
	 * @param nom
	 * @param description
	 * @param prix
	 * @param categorie
	 */
	public Pizza(Integer id, String code, String nom, String description, BigDecimal prix, CategoriePizza categorie) {
		this(id, code, nom, description, prix);
		this.setCategorie(categorie);
	}

	/**
	 * @param id
	 * @param code
	 * @param nom
	 * @param description
	 * @param prix
	 * @param categorie
	 */
	public Pizza(Integer id, String code, String nom, String description, BigDecimal prix, String categorie) {
		this(id, code, nom, description, prix);
		this.setCategorie(categorie);
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the prix
	 */
	public BigDecimal getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
		this.prix.setScale(2, RoundingMode.HALF_UP);
	}
	
	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(String prix) {
		setPrix(BigDecimal.valueOf(Double.parseDouble(prix)));
	}


	/**
	 * @return the categorie
	 */
	public CategoriePizza getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	/**
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(String categorie) {
		for (int i = 0; i < CategoriePizza.values().length; i++) {
			//Egalité sur le nom de l'énumération || Egalité sur la valeur de l'énumération
			if (categorie.equalsIgnoreCase(CategoriePizza.values()[i].name()) || categorie.equalsIgnoreCase(CategoriePizza.values()[i].getCategorie())) {
				this.categorie = CategoriePizza.values()[i];
			}
		}
	}

	/**
	 * @return the urlImage
	 */
	public String getUrlImage() {
		return urlImage;
	}

	/**
	 * @param urlImage
	 *            the urlImage to set
	 */
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.code + " -> " + this.nom + " (" + this.prix + " €) : " + this.categorie;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEqual = false;
		if (obj instanceof Pizza) {
			Pizza pizza = (Pizza) obj;
			isEqual = new EqualsBuilder().appendSuper(super.equals(pizza)).append(this.id, pizza.id)
					.append(this.code, pizza.code).isEquals();
		}
		return isEqual;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder(12, 7).append(this.code).append(this.id).toHashCode();
	}

}
