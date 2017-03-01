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
public class ChatConsoleView extends ViewComposite implements ChatObserver<ChatMessage>{
	
	private ChatConsoleTitleView titleView;
	private ChatConsoleLoginView loginView;
	private ChatConsoleConversationView conversationView;

	/**
	 * 
	 */
	public ChatConsoleView(Scanner scan) {
		this.titleView = new ChatConsoleTitleView();
		this.add(this.titleView);
		this.loginView = new ChatConsoleLoginView(scan);
		this.add(this.loginView);
		this.conversationView = new ChatConsoleConversationView(scan);
		this.add(this.conversationView);
	}

	/**
	 * @return the titleView
	 */
	public ChatConsoleTitleView getTitleView() {
		return titleView;
	}

	/**
	 * @return the loginView
	 */
	public ChatConsoleLoginView getLoginView() {
		return loginView;
	}

	/**
	 * @return the consoleView
	 */
	public ChatConsoleConversationView getConversationView() {
		return conversationView;
	}

	/* (non-Javadoc)
	 * @see dta.chat.model.observer.ChatObserver#update(dta.chat.model.observer.ChatObservable, java.lang.Object)
	 */
	@Override
	public void update(ChatObservable<ChatMessage> obersvable, ChatMessage obj) {
		if(obj.getText() != null){
			this.conversationView.update(obersvable, obj);
		}
		if(this.login == null){
			this.setLogin(obj.getLogin());
		}
	}	
}
