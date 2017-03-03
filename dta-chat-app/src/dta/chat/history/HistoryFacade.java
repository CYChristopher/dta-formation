/**
 * 2 mars 2017 Christopher CHARLERY
 */
package dta.chat.history;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatMessage;

/**
 * @author Christopher CHARLERY
 *
 */
public class HistoryFacade {

	private List<ChatMessage> messages;
	private String cheminDossier;
	private File dossierData;
	private Path fichier;

	/**
	 * 
	 */
	public HistoryFacade(String ipServeur, String portServeur) {
		try {
			this.cheminDossier = new File("").getCanonicalPath();
			this.dossierData = new File(this.cheminDossier + "\\data\\history");
			this.dossierData.mkdirs();
			String cheminFichier = this.dossierData.getCanonicalPath() + "\\" + ipServeur + "=" + portServeur + ".txt";
			this.fichier = Paths.get(cheminFichier);
			this.messages = new ArrayList<ChatMessage>();
		} catch (IOException e) {
			System.out.println("Le dossier data\\history est introuvable !");
		}
	}

	public List<ChatMessage> findLastMessages() throws ChatClientException {
		try {
			if (this.fichier.toFile().exists()) {
				List<String> lignes = Files.readAllLines(this.fichier);
				lignes.forEach((ligne) -> {
					if (ligne != null) {
						String[] donnees = ligne.split(" : ");
						ChatMessage chat = new ChatMessage(donnees[0], donnees[1]);
						this.messages.add(chat);
					}
				});
			}
		} catch (IOException e) {
			System.out.println("Le fichier " + this.fichier.toString() + " est introuvable !");
		}
		return messages;
	}

	public void saveMessage(ChatMessage message) throws ChatClientException {
		try {
			List<String> donnees = new ArrayList<String>();
			StringBuilder sb = new StringBuilder();
			sb.append(message.getLogin()).append(" : ").append(message.getText());
			donnees.add(sb.toString());
			if (this.fichier.toFile().exists()) {
				Files.write(this.fichier, donnees, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
			} else {
				Files.write(this.fichier, donnees, StandardCharsets.UTF_8);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Le fichier " + this.fichier.toString() + " est introuvable !");
		}
	}

}
