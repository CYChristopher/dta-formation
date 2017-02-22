/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

/**
 * @author Christopher CHARLERY
 *
 */
public abstract class Choix {
	
	private Integer numeroChoix;
	private String nomChoix;
	
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 */
	public Choix(Integer numeroChoix, String nomChoix) {
		super();
		this.numeroChoix = numeroChoix;
		this.nomChoix = nomChoix;
	}

	public abstract void faireUneAction(Integer numeroChoix);

	/**
	 * @return the numeroChoix
	 */
	public int getNumeroChoix() {
		return numeroChoix;
	}

	/**
	 * @param numeroChoix the numeroChoix to set
	 */
	public void setNumeroChoix(Integer numeroChoix) {
		this.numeroChoix = numeroChoix;
	}

	/**
	 * @return the nomChoix
	 */
	public String getNomChoix() {
		return nomChoix;
	}

	/**
	 * @param nomChoix the nomChoix to set
	 */
	public void setNomChoix(String nomChoix) {
		this.nomChoix = nomChoix;
	}

}
