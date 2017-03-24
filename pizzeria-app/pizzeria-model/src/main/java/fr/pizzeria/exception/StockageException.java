/**
 * 23 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.exception;

/**
 * @author Christopher CHARLERY
 *
 */
public class StockageException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9039321928946892760L;
	
	/**
	 * Crée une nouvelle instance d'une exception sur le stockage des pizzas
	 * @param message
	 */
	public StockageException(String message) {
		super(message);
	}

}
