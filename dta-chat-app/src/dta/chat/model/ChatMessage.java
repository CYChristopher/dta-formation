/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.model;

import java.io.Serializable;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatMessage implements Serializable{
	
	private static final long serialVersionUID = 12L;
	private String login;
	private String text;
	
	/**
	 * @param login
	 * @param text
	 */
	public ChatMessage(String login, String text) {
		super();
		this.login = login;
		this.text = text;
	}
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.login + " : " + this.text;
	}
	
}
