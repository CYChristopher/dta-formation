/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihmtools;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author Christopher CHARLERY
 *
 */
public class Menu {
	
	private Map<Integer,Choix<?,?>> items;
	private String titre;
	
	/**
	 * 
	 * @param taille
	 */
	public Menu(String titre) {
		this.titre = titre;
		this.items = new HashMap<Integer,Choix<?,?>>();
	}


	/**
	 * Ajoute un choix au menu
	 * @param choix
	 */
	public void addChoix(Choix<?,?> choix){
		this.items.put(choix.getNumeroChoix(), choix);
	}
	
	/**
	 * Effectue l'action lié au choix choisi par l'utilisateur
	 * @param numero
	 */
	public Boolean appliquerChoix(Integer numero) {
		Boolean continuer = true;
		continuer = this.items.get(numero).faireUneAction();
		return continuer;
	}
	
	/**
	 * Affiche le menu des items
	 */
	public void show() {
		System.out.println(this.titre);
		this.items.forEach(new BiConsumer<Integer, Choix<?,?>>() {
			@Override
			public void accept(Integer id, Choix<?, ?> choix) {
				System.out.println(id + ". " + choix.getNomChoix());
			}
		});
	}

}
