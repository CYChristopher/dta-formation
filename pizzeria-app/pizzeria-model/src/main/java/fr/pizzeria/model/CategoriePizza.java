/**
 * 9 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

/**
 * @author Christopher CHARLERY
 *
 */
public enum CategoriePizza {

	VIANDE ("Viande"), POISSON ("Poisson"), VEGETARIENNE ("Végétarienne"), FROMAGE ("Fromage");
	
private final String categorie;
	
	/**
	 * 
	 */
	private CategoriePizza(String categ) {
		this.categorie = categ;
	}

	/**
	 * @return the categorie
	 */
	public String getCategorie() {
		return categorie;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return categorie;
	}
	
}
