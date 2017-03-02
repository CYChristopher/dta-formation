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

	private ClientSocket socket;
	
	/**
	 * 
	 */
	public ChatSocketImpl(String hostname, Integer port) {
		try {
			this.socket = new ClientSocket(hostname, port);
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.AutoCloseable#close()
	 */
	@Override
	public void close() throws Exception {
		this.socket.close();
	}

	/* (non-Javadoc)
	 * @see dta.chat.model.socket.ChatSocket#sendMessage(dta.chat.model.ChatMessage)
	 */
	@Override
	public void sendMessage(ChatMessage chatMessage) throws ChatClientException {
		try {
			this.socket.sendObject(chatMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see dta.chat.model.socket.ChatSocket#readMessage()
	 */
	@Override
	public ChatMessage readMessage() throws ChatClientException {
		ChatMessage chatMessage = null ;
		try {
			chatMessage = (ChatMessage) this.socket.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return chatMessage;
	}

}
