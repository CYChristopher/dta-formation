/**
 * 22 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.util.List;

/**
 * @author Christopher CHARLERY
 * @param <I> Index
 * @param <O> Objet de la dao
 */
public interface ItemDao<I, O> {
	
	/**
	 * 
	 * @return 
	 */
	List<O> getItems();

	/**
	 * Initialise et retourne le tableau d'item
	 * @return
	 */
	void findAllItems();
	
	/**
	 * Retourne un item particulier
	 * @param code
	 * @return
	 */
	O find(I code);
	
	/**
	 * Ajoute un nouvel item dans le tableau
	 * @param item
	 * @throws SaveItemException
	 */
	void saveNewItem(O item); 
	
	/**
	 * Mets � jour un item
	 * @param index 
	 * @param item
	 * @throws UpdateItemException
	 */
	void updateItem(I index,O item);
	
	/**
	 * Supprime un item
	 * @param index
	 * @throws DeleteItemException
	 */
	void deleteItem(I index);
}
