/**
 * 1 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Client;

/**
 * @author Christopher CHARLERY
 *
 */
public class ClientDaoImpl implements ItemDao<Integer, Client> {

	private List<Client> lesClients = new ArrayList<>();

	/**
	 * Crée un nouveau dao d'un client
	 */
	public ClientDaoImpl() {
		this.lesClients = new ArrayList<>();
		findAllItems();
	}	
	
	/**
	 * @return the lesClients
	 */
	@Override
	public List<Client> getItems() {
		return this.lesClients;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#findAllItems()
	 */
	@Override
	public void findAllItems() {
		Client jRobert = new Client(12, "Robert", "Jules", BigDecimal.valueOf(200.0));
		this.lesClients.add(jRobert);

		Client hRobert = new Client(15, "Robert", "Hugues", BigDecimal.valueOf(2.0));
		this.lesClients.add(hRobert);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#saveNewItem(java.lang.Object)
	 */
	@Override
	public void saveNewItem(Client item) throws StockageException {
		//Implémentation à effectuer ultérieurement
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#updateItem(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public void updateItem(Integer index, Client item) throws StockageException {
		//Implémentation à effectuer ultérieurement
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#deleteItem(java.lang.Object)
	 */
	@Override
	public void deleteItem(Integer index) throws StockageException {
		// Implémentation à effectuer ultérieurement
	}
}
