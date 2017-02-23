/**
 * 23 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.exception;

/**
 * @author Christopher CHARLERY
 *
 */
public class SavePizzaException extends StockageException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7445204693366987825L;

	/**
	 * 
	 */
	public SavePizzaException(String message) {
		super(message);
	}

}
