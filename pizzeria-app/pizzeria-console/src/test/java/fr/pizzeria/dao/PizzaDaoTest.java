package fr.pizzeria.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.model.Pizza;

/**
 * 29 mars 2017 Christopher CHARLERY
 */

/**
 * @author Christopher CHARLERY
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-config.xml","/dao-memoire-config.xml" })
public class PizzaDaoTest {

	@Autowired
	private ItemDao<String, Pizza> pizzaDao;

	@Test
	public void testFindAll() {
		List<Pizza> listPizzas = pizzaDao.getItems();
		assertTrue(listPizzas.size() == 8);
	}
}
