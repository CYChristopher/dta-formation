/**
 * 29 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.dao.annotation.DaoSource;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.ValidationException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaValidator;

/**
 * @author Christopher CHARLERY
 *
 */
@Repository
@DaoSource
public class SpringPizzaDaoJpa implements ItemDao<String, Pizza> {

	private static final String GET_BY_CODE = "getByCode";

	@PersistenceContext
	private EntityManager em;
	private List<Pizza> pizzas;
	private PizzaValidator validator;

	/**
	 * 
	 */
	public SpringPizzaDaoJpa() {
		this.pizzas = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#getItems()
	 */
	@Override
	public List<Pizza> getItems() {
		return this.pizzas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#findAllItems()
	 */
	@Override
	public void findAllItems() {
		TypedQuery<Pizza> query = em.createNamedQuery("findAll", Pizza.class);
		this.pizzas = query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#find(java.lang.Object)
	 */
	@Override
	public Pizza find(String code) {
		return em.createNamedQuery(GET_BY_CODE, Pizza.class).setParameter("code", code).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#saveNewItem(java.lang.Object)
	 */
	@Override
	@Transactional(rollbackFor = ValidationException.class)
	public void saveNewItem(Pizza item) {
		this.validator.verifySaisie(item);
		em.persist(item);
		this.pizzas.add(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#updateItem(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	@Transactional(rollbackFor = { ValidationException.class, StockageException.class })
	public void updateItem(String index, Pizza item) {
		Pizza pizza = em.createNamedQuery(GET_BY_CODE, Pizza.class).setParameter("code", index).getSingleResult();
		Optional<Pizza> optPizza = this.pizzas.stream().filter(laPizza -> index.equalsIgnoreCase(laPizza.getCode()))
				.findFirst();
		if (optPizza.isPresent()) {
			pizza.setCode(item.getCode());
			pizza.setNom(item.getNom());
			pizza.setCategorie(item.getCategorie());
			pizza.setDescription(item.getDescription());
			pizza.setPrix(item.getPrix());
			em.merge(pizza);
			this.pizzas.set(this.pizzas.indexOf(optPizza.get()), pizza);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#deleteItem(java.lang.Object)
	 */
	@Override
	@Transactional(rollbackFor = { ValidationException.class, StockageException.class })
	public void deleteItem(String index) {
		Pizza pizza = em.createNamedQuery(GET_BY_CODE, Pizza.class).setParameter("code", index).getSingleResult();
		this.validator.verifyCode(index);
		Optional<Pizza> optPizza = this.pizzas.stream()
				.filter(laPizza -> index.equalsIgnoreCase(laPizza.getCode())).findFirst();
		if (optPizza.isPresent()) {
			em.remove(pizza);
			this.pizzas.remove(optPizza.get());
		}
	}

}
