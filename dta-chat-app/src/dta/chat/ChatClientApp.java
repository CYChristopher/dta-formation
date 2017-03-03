/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat;

import java.io.IOException;
import java.util.Scanner;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatConversationModel;
import dta.chat.model.ChatMessage;
import dta.chat.model.socket.ChatSocketProxy;
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
			System.out.print("Veuillez rentrer le port du serveur : ");
			Integer portServeur = Integer.parseInt(scan.nextLine());
			ChatSocketProxy chatSocket = new ChatSocketProxy(ipServeur, portServeur);
			ChatConversationModel model = new ChatConversationModel(chatSocket);
			final ChatConsoleView view = new ChatConsoleView(scan);

			view.setAuthController((login) -> {
				model.setLogin(login); // Notifie les vues abonnées
			});

			view.setConvController((message) -> {
				try {
					if (message != null && !message.equalsIgnoreCase("exit") && !message.trim().equalsIgnoreCase("")) {
						model.sendMessage(new ChatMessage(view.getLogin(), message));
					} else {
						model.setStayConnected(false);
					}
				} catch (IOException | ChatClientException e) {
					e.printStackTrace();
				}
			});

			view.setModel(model);
			model.addObserver(view);

			new Thread(() -> {
				while (model.getStayConnected()) {
					try {
						model.getMessage();
					} catch (ChatClientException e) {
						System.out.println("Au revoir :)");
					}
				}
			}).start();

			view.print();

		} catch (NumberFormatException e) {
			System.out.println("Vous devez rentrer un numero de port valide !");
		} catch (ChatClientException e) {
			e.printStackTrace();
		}
	}

}
