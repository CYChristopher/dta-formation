/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.model;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatMessage {
	
	private String login;
	private String text;
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
}
