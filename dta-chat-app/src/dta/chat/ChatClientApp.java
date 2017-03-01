/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat;

import java.util.Scanner;

import dta.chat.view.console.ChatConsoleView;
import dta.chat.view.console.ViewComposite;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatClientApp {
	
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			ViewComposite view = new ChatConsoleView(scan);
			view.setAuthController((login) -> {
				view.setLogin(login);
			});
			view.print();
		}
	}

}
