/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

/**
 * @author Christopher CHARLERY
 *
 */
public class Menu {
	
	private Choix[] items;
	
	/**
	 * 
	 */
	public Menu(Integer taille) {
		super();
		items = new Choix[taille];
	}


	/**
	 * Ajoute un choix au menu
	 * @param choix
	 */
	public void addChoix(Choix choix){
		for(int i = 0; i < items.length; i++){
			if(items[i] == null){
				items[i] = choix;
				break;
			}
		}
	}
	
	/**
	 * Affiche le menu des pizzas
	 */
	public void show() {
		System.out.println("***** Pizzeria Administration V2 *****");
		for(int i = 0; i < items.length; i++){
			if(items[i] != null){
				System.out.println(items[i].getNumeroChoix() + ". " + items[i].getNomChoix());
			}
		}
	}

}
