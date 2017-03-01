/**
 * 1 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.AbstractPersonne;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;

/**
 * @author Christopher CHARLERY
 *
 */
public class IPersonneDaoImpl implements IItemDao<Integer, AbstractPersonne> {
	
	private List<Client> lesClients = new ArrayList<Client>();
	private List<Livreur> lesLivreurs = new ArrayList<Livreur>();

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IItemDao#findAllItems()
	 */
	@Override
	public List<AbstractPersonne> findAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IItemDao#initializeList()
	 */
	@Override
	public void initializeList() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IItemDao#saveNewItem(java.lang.Object)
	 */
	@Override
	public void saveNewItem(AbstractPersonne item) throws StockageException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IItemDao#updateItem(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void updateItem(Integer idItem, AbstractPersonne item) throws StockageException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IItemDao#deleteItem(java.lang.Object)
	 */
	@Override
	public void deleteItem(Integer idItem) throws StockageException {
		// TODO Auto-generated method stub

	}

}
