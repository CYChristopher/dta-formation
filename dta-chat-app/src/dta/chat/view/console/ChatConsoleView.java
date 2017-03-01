/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.view.console;

import java.util.Scanner;

import dta.chat.controller.ChatAuthController;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatConsoleView extends ViewComposite{
	
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
}
