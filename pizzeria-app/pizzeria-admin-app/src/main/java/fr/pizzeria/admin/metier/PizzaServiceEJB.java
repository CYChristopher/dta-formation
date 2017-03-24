/**
 * 24 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaValidator;

/**
 * @author Christopher CHARLERY
 *
 */
@Stateless
public class PizzaServiceEJB {

	@PersistenceContext(unitName = "pizzeria-admin-app")
	private EntityManager em;
	private static final String GET_BY_CODE = "getByCode";
	@Inject
	private PizzaValidator validator;

	/**
	 * 
	 * @return
	 */
	public List<Pizza> findAllItems() {
		return em.createNamedQuery("findAll", Pizza.class).getResultList();
	}

	/**
	 * 
	 * @param codePizza
	 * @return
	 */
	public Pizza find(String codePizza) {
		return em.createNamedQuery(GET_BY_CODE, Pizza.class).setParameter("code", codePizza).getSingleResult();
	}

	/**
	 * 
	 * @param item
	 */
	public void saveNewItem(Pizza item) {
		this.validator.verifySaisie(item);
		em.persist(item);
	}

	/**
	 * 
	 * @param codePizza
	 * @param item
	 */
	public void updateItem(String codePizza, Pizza item) {
		this.validator.verifyCode(codePizza);
		this.validator.verifySaisie(item);
		Pizza pizza = em.createNamedQuery(GET_BY_CODE, Pizza.class).setParameter("code", codePizza).getSingleResult();
		pizza.setCode(item.getCode());
		pizza.setNom(item.getNom());
		pizza.setCategorie(item.getCategorie());
		pizza.setDescription(item.getDescription());
		pizza.setPrix(item.getPrix());
		em.merge(pizza);
	}

	/**
	 * 
	 * @param codePizza
	 */
	public void deleteItem(String codePizza) {
		this.validator.verifyCode(codePizza);
		Pizza pizza = em.createNamedQuery(GET_BY_CODE, Pizza.class).setParameter("code", codePizza).getSingleResult();
		em.remove(pizza);
	}
}
