/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.model;

import dta.chat.exception.ChatClientException;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.ChatSocketImpl;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatConversationModel extends ChatObservable<ChatMessage> {
	
	private String login;
	private ChatSocketImpl chatSocket;
	private Boolean stayConnected;
	
	/**
	 * 
	 */
	public ChatConversationModel(ChatSocketImpl chatSocket) {
		this.chatSocket = chatSocket;
		this.setStayConnected(true);
	}
	
	public void setLogin(String login){
		this.login = login;
		this.notifyObservers(new ChatMessage(login, null));
	}
	
	public void setMessage() throws ChatClientException{
		this.notifyObservers(this.chatSocket.readMessage());
	}
	
	public void sendMessage(ChatMessage chat) throws ChatClientException{
		this.chatSocket.sendMessage(chat);
	}

	/**
	 * @return the stayConnected
	 */
	public Boolean getStayConnected() {
		return stayConnected;
	}

	/**
	 * @param stayConnected the stayConnected to set
	 */
	public void setStayConnected(Boolean stayConnected) {
		this.stayConnected = stayConnected;
	}

}
