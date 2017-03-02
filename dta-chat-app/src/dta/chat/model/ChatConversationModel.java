/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.model;

import java.io.IOException;

import dta.chat.exception.ChatClientException;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.ChatSocketImpl;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatConversationModel extends ChatObservable<ChatMessage> {
	
	private ChatSocketImpl chatSocket;
	private Boolean stayConnected;
	
	/**
	 * @throws IOException 
	 * 
	 */
	public ChatConversationModel(ChatSocketImpl chatSocket) {
		this.chatSocket = chatSocket;
		this.stayConnected = true;
	}
	
	public void setLogin(String login){
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
	 * @throws IOException 
	 */
	public void setStayConnected(Boolean stayConnected) throws IOException {
		this.stayConnected = stayConnected;
		if(!this.stayConnected){
			this.chatSocket.close();
		}
	}

}
