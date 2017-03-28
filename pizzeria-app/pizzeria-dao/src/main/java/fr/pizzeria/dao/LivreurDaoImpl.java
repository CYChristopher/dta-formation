/**
 * 1 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Livreur;

/**
 * @author Christopher CHARLERY
 *
 */
public class LivreurDaoImpl implements ItemDao<Integer,Livreur> {

	private List<Livreur> lesLivreurs = new ArrayList<>();

	
	
	/**
	 * @return the lesLivreurs
	 */
	@Override
	public List<Livreur> getItems() {
		return lesLivreurs;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IItemDao#findAllItems()
	 */
	@Override
	public void findAllItems() {
		Livreur dRobert = new Livreur(1, "Robert", "Daniel", BigDecimal.valueOf(50.0));
		this.lesLivreurs.add(dRobert);
		
		Livreur gRobert = new Livreur(3, "Robert", "Gerard", BigDecimal.valueOf(75.0));
		this.lesLivreurs.add(gRobert);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IItemDao#saveNewItem(java.lang.Object)
	 */
	@Override
	public void saveNewItem(Livreur item){
		// Implémentation à effectuer ultérieurement

	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IItemDao#updateItem(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void updateItem(Integer index, Livreur item){
		// Implémentation à effectuer ultérieurement

	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IItemDao#deleteItem(java.lang.Object)
	 */
	@Override
	public void deleteItem(Integer index){
		// Implémentation à effectuer ultérieurement

	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.ItemDao#find(java.lang.Object)
	 */
	@Override
	public Livreur find(Integer code) {
		return null;
	}

}
