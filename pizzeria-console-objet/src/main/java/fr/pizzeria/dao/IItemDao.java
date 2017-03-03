/**
 * 22 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.StockageException;

/**
 * @author Christopher CHARLERY
 *
 */
public interface IItemDao<I, G> {

	/**
	 * Retourne le tableau d'item
	 * @return
	 */
	List<G> findAllItems();
	
	/**
	 * Initialise le tableau
	 */
	void initializeList();
	
	/**
	 * Ajoute un nouvel item dans le tableau
	 * @param item
	 * @throws SaveItemException
	 */
	void saveNewItem(G item) throws StockageException; 
	
	/**
	 * Mets � jour un item
	 * @param idItem
	 * @param item
	 * @throws UpdateItemException
	 */
	void updateItem(I idItem, G item) throws StockageException;
	
	/**
	 * Supprime un item
	 * @param idItem
	 * @throws DeleteItemException
	 */
	void deleteItem(I idItem) throws StockageException;
}
