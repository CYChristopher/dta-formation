/**
 * 27 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.exception;

/**
 * @author Christopher CHARLERY
 *
 */
public class CreditException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2746796598725214906L;
	
	/**
	 * Crée une nouvelle instance d'une exception sur un crédit
	 * @param message
	 */
	public CreditException(String message) {
		super(message);
	}

}
