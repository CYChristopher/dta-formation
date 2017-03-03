/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.model;

import java.io.IOException;

import dta.chat.exception.ChatClientException;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.ChatSocketProxy;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatConversationModel extends ChatObservable<ChatMessage> {
	
	private ChatSocketProxy chatSocket;
	private Boolean stayConnected;
	
	/**
	 * @throws ChatClientException 
	 * @throws IOException 
	 * 
	 */
	public ChatConversationModel(ChatSocketProxy chatSocket) throws ChatClientException {
		this.chatSocket = chatSocket;
		this.stayConnected = true;
	}
	
	public void setLogin(String login){
		this.notifyObservers(new ChatMessage(login, null));
	}
	
	public void getMessage() throws ChatClientException{
		ChatMessage newMessage = this.chatSocket.readMessage();
		this.notifyObservers(newMessage);
	}
	
	public void sendMessage(ChatMessage chat) throws ChatClientException{
		this.chatSocket.sendMessage(chat);
	}
	
	public void initializeChat() throws ChatClientException{
		this.chatSocket.findLastMessages().forEach((message) -> {
			this.notifyObservers(message);
		});
	}

	/**
	 * @return the stayConnected
	 */
	public Boolean getStayConnected() {
		return stayConnected;
	}

	/**
	 * @param stayConnected the stayConnected to set
	 * @throws Exception 
	 */
	public void setStayConnected(Boolean stayConnected) throws IOException  {
		this.stayConnected = stayConnected;
		if(!this.stayConnected){
			this.chatSocket.close();
		}
	}

}
