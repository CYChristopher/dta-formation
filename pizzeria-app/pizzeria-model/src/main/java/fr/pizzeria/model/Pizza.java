/**
 * 22 f�vr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Christopher CHARLERY
 *
 */
public class Pizza {

	private Integer id;
	private String code;
	private String nom;
	private String description;
	private BigDecimal prix;
	private CategoriePizza categorie;

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
	public Pizza(Integer id, String code, String nom, String description, BigDecimal prix, String categorie) {
		this(id, code, nom, description, prix);
		this.setCategorie(categorie);
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
			if (categorie.equalsIgnoreCase(CategoriePizza.values()[i].toString())) {
				this.categorie = CategoriePizza.values()[i];
			}
		}
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
		if(obj instanceof Pizza){
			Pizza pizza = (Pizza) obj;
			isEqual = new EqualsBuilder().appendSuper(super.equals(pizza)).append(this.id, pizza.id).append(this.code, pizza.code).isEquals();
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
