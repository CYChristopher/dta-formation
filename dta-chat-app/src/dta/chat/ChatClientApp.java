/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat;

import java.util.Scanner;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatConversationModel;
import dta.chat.model.socket.ChatSocketImpl;
import dta.chat.view.console.ChatConsoleView;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatClientApp {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Veuillez rentrer l'adresse du serveur : ");
			String ipServeur = scan.nextLine();
			//"192.168.99.31"
			ChatSocketImpl chatSocket = new ChatSocketImpl(ipServeur, 1800);
			ChatConversationModel model = new ChatConversationModel(chatSocket);
			final ChatConsoleView view = new ChatConsoleView(scan, model);
			view.setAuthController((login) -> {
				model.setLogin(login); // Notifie les vues abonnées
			});
			model.addObserver(view);
			new Thread(() -> {
				if(!model.getStayConnected()){
					try {
						chatSocket.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				while (model.getStayConnected()) {
					try {
						model.setMessage();
					} catch (ChatClientException e) {
						e.printStackTrace();
					}
				}
			}).start();
			view.print();		
		}
	}

}
