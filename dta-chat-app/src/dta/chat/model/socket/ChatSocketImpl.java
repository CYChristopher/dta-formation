/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatMessage;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatSocketImpl implements ChatSocket {

	private ClientSocket client;
	
	/**
	 * 
	 */
	public ChatSocketImpl(String hostname, Integer port) throws ChatClientException{
		try {
			this.client = new ClientSocket(hostname, port);
		} catch (IOException e) {
			throw new ChatClientException("Probleme lors de la création de la connexion", e);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.AutoCloseable#close()
	 */
	@Override
	public void close() throws IOException {
		this.client.close();
	}

	/* (non-Javadoc)
	 * @see dta.chat.model.socket.ChatSocket#sendMessage(dta.chat.model.ChatMessage)
	 */
	@Override
	public void sendMessage(ChatMessage chatMessage) throws ChatClientException {
		try {
			this.client.sendObject(chatMessage);
		} catch (IOException e) {
			throw new ChatClientException("Probleme lors de l'envoi du message", e); 
		}
	}

	/* (non-Javadoc)
	 * @see dta.chat.model.socket.ChatSocket#readMessage()
	 */
	@Override
	public ChatMessage readMessage() throws ChatClientException {
		ChatMessage chatMessage = null ;
		try {
			chatMessage = (ChatMessage) this.client.readObject();
		} catch (ClassNotFoundException | IOException e) {
			throw new ChatClientException("Probleme lors de la reception du message", e); 
		}
		return chatMessage;
	}
}
