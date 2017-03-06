/**
 * 24 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

/**
 * @author Christopher CHARLERY
 *
 */
public enum CategoriePizza {
	
	VIANDE ("Viande"), POISSON ("Poisson"), SANS_VIANDE ("Sans Viande");
	
	private String categorie;
	
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
		// TODO Auto-generated method stub
		return categorie;
	}
}
