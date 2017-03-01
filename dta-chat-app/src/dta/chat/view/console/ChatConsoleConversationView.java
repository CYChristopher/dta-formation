/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.view.console;

import java.util.Scanner;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatConsoleConversationView extends ViewComposite{
	
	private Scanner sc;
	
	/**
	 * 
	 */
	public ChatConsoleConversationView(Scanner scan) {
		this.sc = scan;
	}
	
	/* (non-Javadoc)
	 * @see dta.chat.view.console.ViewComposite#print()
	 */
	@Override
	public void print() {
		System.out.println("== Conversation ==");
		System.out.println("Welcome : " + this.login);
	}
	
	
}
