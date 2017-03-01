/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.view.console;

import java.util.Scanner;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatConsoleView extends ViewComposite{

	/**
	 * 
	 */
	public ChatConsoleView(Scanner scan) {
		this.add(new ChatConsoleTitleView());
		this.add(new ChatConsoleLoginView(scan));
		this.add(new ChatConsoleConversationView(scan));
	}
	
}
