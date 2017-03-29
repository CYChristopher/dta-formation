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
import fr.pizzeria.exception.ValidationException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaValidator;

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
	private PizzaValidator validator;

	/**
	 * Implémentation avec Hibernate
	 */
	public PizzaDaoJpa() {
		this.pizzas = new ArrayList<>();
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String unit = bundle.getString("unit");
		emf = Persistence.createEntityManagerFactory(unit);
		this.validator = new PizzaValidator();
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
			this.validator.verifySaisie(item);
			em.persist(item);
			et.commit();
			this.pizzas.add(item);
		} catch (ValidationException e) {
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
	public void updateItem(String codePizza, Pizza item){
		EntityManager em = emf.createEntityManager();
		Pizza pizza = em.createNamedQuery(GET_BY_CODE, Pizza.class).setParameter("code", codePizza).getSingleResult();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			this.validator.verifyCode(codePizza);
			this.validator.verifySaisie(pizza);
			Optional<Pizza> optPizza = this.pizzas.stream()
					.filter(laPizza -> codePizza.equalsIgnoreCase(laPizza.getCode())).findFirst();
			if (optPizza.isPresent()) {
				pizza.setCode(item.getCode());
				pizza.setNom(item.getNom());
				pizza.setCategorie(item.getCategorie());
				pizza.setDescription(item.getDescription());
				pizza.setPrix(item.getPrix());
				em.merge(pizza);
				et.commit();
				this.pizzas.set(this.pizzas.indexOf(optPizza.get()), pizza);
			} else {
				throw new StockageException("Code incorrect !");
			}
		} catch (StockageException | ValidationException e) {
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
	public void deleteItem(String codePizza){
		EntityManager em = emf.createEntityManager();
		Pizza pizza = em.createNamedQuery(GET_BY_CODE, Pizza.class).setParameter("code", codePizza).getSingleResult();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			this.validator.verifyCode(codePizza);
			Optional<Pizza> optPizza = this.pizzas.stream()
					.filter(laPizza -> codePizza.equalsIgnoreCase(laPizza.getCode())).findFirst();
			if (optPizza.isPresent()) {
				em.remove(pizza);
				et.commit();
				this.pizzas.remove(optPizza.get());
			} else {
				throw new StockageException("Code incorrect !");
			}
		} catch (StockageException | ValidationException e) {
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
