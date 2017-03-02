/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.view.console;

import java.util.Scanner;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChatConsoleLoginView extends ViewComposite{

	private Scanner sc;
	
	/**
	 * 
	 */
	public ChatConsoleLoginView(Scanner scan) {
		this.sc = scan;
	}

	/* (non-Javadoc)
	 * @see dta.chat.view.console.ViewComposite#print()
	 */
	@Override
	public void print() {
		System.out.println("== Authentification ==");
		System.out.print("Veuillez saisir votre login : ");
		String login = sc.nextLine();
		this.authController.authenticate(login);
	}
}
