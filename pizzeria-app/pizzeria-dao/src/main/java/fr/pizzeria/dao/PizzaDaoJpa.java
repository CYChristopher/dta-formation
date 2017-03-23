/**
 * 10 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzaDaoJpa implements ItemDao<String, Pizza> {

	/**
	 * 
	 */
	private static final String GET_BY_CODE = "getByCode";

	private Logger myLogger = Logger.getLogger(this.getClass().getName());

	private List<Pizza> pizzas;
	private EntityManagerFactory emf;
	private DaoPizzaTools daoTools;

	/**
	 * Implémentation avec Hibernate
	 */
	public PizzaDaoJpa() {
		this.pizzas = new ArrayList<>();
		this.daoTools = new DaoPizzaTools();
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String unit = bundle.getString("unit");
		emf = Persistence.createEntityManagerFactory(unit);
		findAllItems();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#findAllItems()
	 */
	@Override
	public void findAllItems() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Pizza> query = em.createNamedQuery("findAll", Pizza.class);
		this.pizzas = query.getResultList();
		em.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#find()
	 */
	@Override
	public Pizza find(String codePizza) {
		EntityManager em = emf.createEntityManager();
		Pizza pizza = em.createNamedQuery(GET_BY_CODE, Pizza.class).setParameter("code", codePizza).getSingleResult();
		em.close();
		return pizza;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#saveNewItem(java.lang.Object)
	 */
	@Override
	public void saveNewItem(Pizza item) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			this.daoTools.verifySaisie(item);
			em.persist(item);
			et.commit();
			this.pizzas.add(item);
		} catch (StockageException e) {
			myLogger.log(Level.WARNING, e.getMessage(), e);
			et.rollback();
		} finally {
			em.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#updateItem(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public void updateItem(String codePizza, Pizza item) throws StockageException {
		EntityManager em = emf.createEntityManager();
		Pizza pizza = em.createNamedQuery(GET_BY_CODE, Pizza.class).setParameter("code", codePizza).getSingleResult();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			this.daoTools.verifyCode(codePizza);
			this.daoTools.verifySaisie(pizza);
			Optional<Pizza> optPizza = this.pizzas.stream()
					.filter(laPizza -> codePizza.equalsIgnoreCase(laPizza.getCode())).findFirst();
			if (optPizza.isPresent()) {
				pizza.setCode(item.getCode());
				pizza.setNom(item.getNom());
				pizza.setDescription(item.getDescription());
				pizza.setPrix(item.getPrix());
				em.merge(pizza);
				et.commit();
				this.pizzas.set(this.pizzas.indexOf(optPizza.get()), pizza);
			} else {
				throw new StockageException("Code incorrect !");
			}
		} catch (StockageException e) {
			myLogger.log(Level.WARNING, e.getMessage(), e);
			et.rollback();
		} finally {
			em.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#deleteItem(java.lang.Object)
	 */
	@Override
	public void deleteItem(String codePizza) throws StockageException {
		EntityManager em = emf.createEntityManager();
		Pizza pizza = em.createNamedQuery(GET_BY_CODE, Pizza.class).setParameter("code", codePizza).getSingleResult();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			this.daoTools.verifyCode(codePizza);
			Optional<Pizza> optPizza = this.pizzas.stream()
					.filter(laPizza -> codePizza.equalsIgnoreCase(laPizza.getCode())).findFirst();
			if (optPizza.isPresent()) {
				em.remove(pizza);
				et.commit();
				this.pizzas.remove(optPizza.get());
			} else {
				throw new StockageException("Code incorrect !");
			}
		} catch (StockageException e) {
			myLogger.log(Level.WARNING, e.getMessage(), e);
			et.rollback();
		} finally {
			em.close();
		}
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

}
