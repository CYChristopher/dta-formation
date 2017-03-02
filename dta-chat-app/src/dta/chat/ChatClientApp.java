/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat;

import java.io.IOException;
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
			System.out.print("Veuillez rentrer le port du serveur : ");
			Integer portServeur = Integer.parseInt(scan.nextLine());
			ChatSocketImpl chatSocket = new ChatSocketImpl(ipServeur, portServeur);
			ChatConversationModel model = new ChatConversationModel(chatSocket);
			final ChatConsoleView view = new ChatConsoleView(scan, model);
			view.setAuthController((login) -> {
				model.setLogin(login); // Notifie les vues abonnées
			});
			model.addObserver(view);
			new Thread(() -> {
				while (model.getStayConnected()) {
					try {
						model.setMessage();
					} catch (ChatClientException e) {
						e.printStackTrace();
					}
				}
			}).start();
			view.print();	
			if(!model.getStayConnected()){
				chatSocket.close();
			}
		} catch (NumberFormatException e){
			System.out.println("Vous devez rentrer un numero de port valide !");
		} catch (IOException | ChatClientException e) {
			e.printStackTrace();
		} 
	}

}
