/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.exception;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatClientException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8517791295861737563L;

	/**
	 * 
	 */
	public ChatClientException(String msg) {
		super(msg);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ChatClientException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
	
}
