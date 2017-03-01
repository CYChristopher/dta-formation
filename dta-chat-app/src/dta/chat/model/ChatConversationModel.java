/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.model;

import dta.chat.model.observer.ChatObservable;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatConversationModel extends ChatObservable<ChatMessage> {
	
	private ChatMessage chatMessage;
	
	/**
	 * 
	 */
	public ChatConversationModel() {
		this.chatMessage = new ChatMessage();
	}
	
	public void setLogin(String login){
		this.chatMessage.setLogin(login);
		this.notifyObservers(chatMessage);
	}
	
	public void setMessage(String message){
		this.chatMessage.setText(message);
		this.notifyObservers(chatMessage);
	}

}
