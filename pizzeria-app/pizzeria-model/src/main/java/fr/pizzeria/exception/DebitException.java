/**
 * 27 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.exception;

/**
 * @author Christopher CHARLERY
 *
 */
public class DebitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4148839767917716670L;
	
	/**
	 * Crée une nouvelle instance d'une exception sur un crédit
	 * @param message
	 */
	public DebitException(String message) {
		super(message);
	}

}
