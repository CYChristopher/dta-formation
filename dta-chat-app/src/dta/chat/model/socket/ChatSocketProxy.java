/**
 * 2 mars 2017 Christopher CHARLERY
 */
package dta.chat.model.socket;

import java.io.IOException;
import java.util.List;

import dta.chat.exception.ChatClientException;
import dta.chat.history.HistoryFacade;
import dta.chat.model.ChatMessage;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatSocketProxy implements ChatSocket{
	
	private ChatSocketImpl chatSocket;
	private HistoryFacade history;
	
	public ChatSocketProxy(String hostname, Integer port) throws ChatClientException{
		this.chatSocket = new ChatSocketImpl(hostname, port);
		this.history = new HistoryFacade(hostname, Integer.toString(port));
	}

	/* (non-Javadoc)
	 * @see java.lang.AutoCloseable#close()
	 */
	@Override
	public void close() throws IOException {
		this.chatSocket.close();
	}

	/* (non-Javadoc)
	 * @see dta.chat.model.socket.ChatSocket#sendMessage(dta.chat.model.ChatMessage)
	 */
	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		if(msg.getText() == null || msg.getText().trim().equals("")){
			throw new ChatClientException("Le message ne peut être vide !");
		} else{
			this.chatSocket.sendMessage(msg);
			this.history.saveMessage(msg);
		}
	}

	/* (non-Javadoc)
	 * @see dta.chat.model.socket.ChatSocket#readMessage()
	 */
	@Override
	public ChatMessage readMessage() throws ChatClientException {
		ChatMessage message = this.chatSocket.readMessage();
		if(message != null && message.getText() == null || message.getText().trim().equals("")){
			message.setText("Message vide");
		}
		this.history.saveMessage(message);
		return message;
	}
	
	public List<ChatMessage> findLastMessages() throws ChatClientException{
		return this.history.findLastMessages();
	}

}
