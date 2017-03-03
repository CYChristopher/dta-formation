/**
 * 1 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Livreur;

/**
 * @author Christopher CHARLERY
 *
 */
public class ILivreurDaoImpl implements IItemDao<Integer, Livreur> {

	private List<Livreur> lesLivreurs = new ArrayList<Livreur>();

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IItemDao#findAllItems()
	 */
	@Override
	public List<Livreur> findAllItems() {
		return this.lesLivreurs;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IItemDao#initializeList()
	 */
	@Override
	public void initializeList() {
		Livreur dRobert = new Livreur(1, "Robert", "Daniel", 50.0);
		this.lesLivreurs.add(dRobert);
		
		Livreur gRobert = new Livreur(3, "Robert", "Gerard", 75.0);
		this.lesLivreurs.add(gRobert);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IItemDao#saveNewItem(java.lang.Object)
	 */
	@Override
	public void saveNewItem(Livreur item) throws StockageException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IItemDao#updateItem(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void updateItem(Integer idItem, Livreur item) throws StockageException {
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
