/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.view.console;

import java.util.Scanner;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.observer.ChatObserver;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatConsoleConversationView extends ViewComposite implements ChatObserver<ChatMessage> {

	private Scanner sc;

	/**
	 * 
	 */
	public ChatConsoleConversationView(Scanner scan) {
		this.sc = scan;
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
