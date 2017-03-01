/**
 * 1 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Client;

/**
 * @author Christopher CHARLERY
 *
 */
public class IClientDaoImpl implements IItemDao<Integer, Client> {

	private List<Client> lesClients = new ArrayList<Client>();

	/**
	 * 
	 */
	public IClientDaoImpl() {
		this.lesClients = new ArrayList<Client>();
		initializeList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#findAllItems()
	 */
	@Override
	public List<Client> findAllItems() {
		return lesClients;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#initializeList()
	 */
	@Override
	public void initializeList() {
		Client jRobert = new Client(12, "Robert", "Jules", 200.0);
		this.lesClients.add(jRobert);

		Client hRobert = new Client(15, "Robert", "Hugues", 2.0);
		this.lesClients.add(hRobert);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#saveNewItem(java.lang.Object)
	 */
	@Override
	public void saveNewItem(Client item) throws StockageException {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#updateItem(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public void updateItem(Integer idItem, Client item) throws StockageException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#deleteItem(java.lang.Object)
	 */
	@Override
	public void deleteItem(Integer idItem) throws StockageException {
		// TODO Auto-generated method stub
	}
}
