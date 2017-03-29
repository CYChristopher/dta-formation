package fr.pizzeria.dao;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.annotation.DaoSource;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * 29 mars 2017 Christopher CHARLERY
 */

/**
 * @author Christopher CHARLERY
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DaoConfig.class)
public class SpringDaoTest {

	@Autowired
	@DaoSource
	private ItemDao<String, Pizza> pizzaDao;

	@Before
	public void init() {
		assertNotNull(pizzaDao);
	}

	@Test
	public void findAllTest() {
		pizzaDao.findAllItems();
		List<Pizza> pizzas = pizzaDao.getItems();
		assertTrue(pizzas.size() > 0);
	}

	@Test
	public void findTest() {
		Pizza pizza = pizzaDao.find("rei");
		assertNotNull(pizza);
		assertTrue(pizza.getCode().equals("REI"));
	}

	@Test
	public void saveItemTest() {
		Pizza pizza = new Pizza("TEST", "Save test", "Ceci est un test unitaire", BigDecimal.valueOf(12.5),
				CategoriePizza.VEGETARIENNE);
		pizzaDao.findAllItems();
		Integer size = pizzaDao.getItems().size();
		pizzaDao.saveNewItem(pizza);
		assertNotNull(pizzaDao.find("TEST"));
		pizzaDao.findAllItems();
		assertTrue(pizzaDao.getItems().size() == ++size);
	}
	
	@Test
	public void updateItemTest(){
		Pizza pizza = new Pizza("TEUT", "Update test", "Ceci est un test unitaire", BigDecimal.valueOf(12.5),
				CategoriePizza.VEGETARIENNE);
		pizzaDao.saveNewItem(pizza);
		assertNotNull(pizzaDao.find("TEUT"));
		pizza = pizzaDao.find("TEUT");
		pizza.setNom("I'm an update");
		pizza.setCode("TTTT");
		pizzaDao.updateItem("TEUT", pizza);
		assertNotNull(pizzaDao.find("TTTT"));
	}
	
	@Test
	public void deleteItemTest(){
		Pizza pizza = new Pizza("TEDT", "Delete test", "Ceci est un test unitaire", BigDecimal.valueOf(12.5),
				CategoriePizza.VEGETARIENNE);
		pizzaDao.saveNewItem(pizza);
		assertNotNull(pizzaDao.find("TEDT"));
		pizzaDao.findAllItems();
		Integer size = pizzaDao.getItems().size();
		pizzaDao.deleteItem("TEDT");
		pizzaDao.findAllItems();
		assertTrue(pizzaDao.getItems().size() == --size);
	}

}
