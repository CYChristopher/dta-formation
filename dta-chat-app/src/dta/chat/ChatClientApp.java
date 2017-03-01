/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat;

import java.util.Scanner;

import dta.chat.model.ChatConversationModel;
import dta.chat.view.console.ChatConsoleView;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatClientApp {
	
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			ChatConversationModel model = new ChatConversationModel();
			final ChatConsoleView view = new ChatConsoleView(scan);
			view.setAuthController((login) -> {
				model.setLogin(login); // Notifie les vues abonnées
			});
			
			model.addObserver(view);
			
			view.print();
			
			model.setMessage("Bonjour");
			model.setMessage("C'est moi !");
		}
	}

}
