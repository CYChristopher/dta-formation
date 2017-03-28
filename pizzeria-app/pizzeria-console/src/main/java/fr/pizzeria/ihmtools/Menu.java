/**
 * 22 février 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihmtools;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Christopher CHARLERY
 *
 */
public class Menu {

	private Map<Integer, Choix<?, ?>> items;
	private String titre;

	/**
	 * 
	 * @param titre
	 */
	public Menu(String titre) {
		this.titre = titre;
		this.items = new TreeMap<>();
	}

	/**
	 * Ajoute un choix au menu
	 * 
	 * @param choix
	 */
	public void addChoix(Choix<?, ?> choix) {
		this.items.put(choix.getNumeroChoix(), choix);
	}

	/**
	 * Effectue l'action liée au choix choisi par l'utilisateur
	 * 
	 * @param numero
	 * @return
	 */
	public Boolean appliquerChoix(Integer numero) {
		Boolean continuer;
		continuer = this.items.get(numero).faireUneAction();
		return continuer;
	}

	/**
	 * Affiche le menu des items
	 */
	public void show() {
		System.out.println(this.titre);
		this.items.forEach((id, choix) -> System.out.println(id + ". " + choix.getNomChoix()));
	}

	/**
	 * @return the items
	 */
	public Map<Integer, Choix<?, ?>> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Map<Integer, Choix<?, ?>> items) {
		this.items = items;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
}
