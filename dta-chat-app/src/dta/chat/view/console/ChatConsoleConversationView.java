/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.view.console;

import java.util.Scanner;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatConversationModel;
import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.observer.ChatObserver;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatConsoleConversationView extends ViewComposite implements ChatObserver<ChatMessage> {

	private Scanner sc;
	private String message;
	private ChatConversationModel model;

	/**
	 * 
	 */
	public ChatConsoleConversationView(Scanner scan, ChatConversationModel model) {
		this.sc = scan;
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dta.chat.view.console.ViewComposite#print()
	 */
	@Override
	public void print() {
		System.out.println("Welcome : " + this.login);
		System.out.println("== Conversation ==");
		while (this.model.getStayConnected()) {
			this.message = sc.nextLine();
			if (this.message != null && !this.message.equalsIgnoreCase("exit") && !this.message.trim().equalsIgnoreCase("")) {
				try {
					this.model.sendMessage(new ChatMessage(this.login, this.message));
				} catch (ChatClientException e) {
					e.printStackTrace();
				}
			} else {
				this.model.setStayConnected(false);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dta.chat.model.observer.ChatObserver#update(dta.chat.model.observer.
	 * ChatObservable, java.lang.Object)
	 */
	@Override
	public void update(ChatObservable<ChatMessage> obersvable, ChatMessage obj) {
		System.out.println(obj.getLogin() + " : " + obj.getText());
	}

}
