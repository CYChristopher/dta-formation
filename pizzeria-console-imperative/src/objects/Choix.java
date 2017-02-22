/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package objects;

/**
 * @author Christopher CHARLERY
 *
 */
public abstract class Choix {

	private int numeroChoix;
	private String nomChoix;
	
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 */
	public Choix(int numeroChoix, String nomChoix) {
		super();
		this.numeroChoix = numeroChoix;
		this.nomChoix = nomChoix;
	}

	public abstract void faireUneAction(int numeroChoix);

	/**
	 * @return the numeroChoix
	 */
	public int getNumeroChoix() {
		return numeroChoix;
	}

	/**
	 * @param numeroChoix the numeroChoix to set
	 */
	public void setNumeroChoix(int numeroChoix) {
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
