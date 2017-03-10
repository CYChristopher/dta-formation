/**
 * 22 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.StockageException;

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
	 * Ajoute un nouvel item dans le tableau
	 * @param item
	 * @throws SaveItemException
	 */
	void saveNewItem(O item) throws StockageException; 
	
	/**
	 * Mets � jour un item
	 * @param index 
	 * @param item
	 * @throws UpdateItemException
	 */
	void updateItem(I index,O item) throws StockageException;
	
	/**
	 * Supprime un item
	 * @param index
	 * @throws DeleteItemException
	 */
	void deleteItem(I index) throws StockageException;
}
