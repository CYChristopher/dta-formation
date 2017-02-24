/**
 * 22 f�vr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

import java.lang.reflect.Field;

/**
 * @author Christopher CHARLERY
 *
 */
public class Pizza {

	private Integer id;
	@ToString(uppercase = false)
	private String code;
	@ToString(uppercase = true)
	private String nom;
	private Double prix;
	private CategoriePizza categorie;

	/**
	 * @param id
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(Integer id, String code, String nom, Double prix, CategoriePizza categ) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.setCategorie(categ);
	}

	/**
	 * @return the id
	 */
	public int getId() {
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
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(Double prix) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		for (Field field : this.getClass().getDeclaredFields()) {
			ToString annotationTrouve = field.getAnnotation(ToString.class);
			if (field.isAnnotationPresent(ToString.class)) {
				try {
					String valeur = (String) field.get(this);
					if (annotationTrouve.uppercase()) {
						valeur = valeur.toUpperCase();
					} else {
						valeur = valeur.toLowerCase();
					}
					description.append(valeur);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				description.append(" ");
			}
		}
		return description.toString();
		// return this.code + " -> " + this.nom + " (" + this.prix + " �) : " + this.categorie;
	}

}
