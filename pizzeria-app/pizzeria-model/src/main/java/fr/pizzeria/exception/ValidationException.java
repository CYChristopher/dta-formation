/**
 * 24 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.exception;

/**
 * @author Christopher CHARLERY
 *
 */
public class ValidationException extends RuntimeException {
	
	/**
	 * Crée une nouvelle Exception de validation
	 */
	public ValidationException(String message) {
		super(message);
	}

}
