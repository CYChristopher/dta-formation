/**
 * 3 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class IPizzaDaoImplTest {
	
	private PizzaDaoImplFile pizzaDao;
	
	/*@Before
	public void test(){
		pizzaDao = new IPizzaDaoImpl();
	}*/
	
	@Test
	public void testFindAll(){
		List<Pizza> pizzas = pizzaDao.findAllItems();		
		assertEquals(9, pizzas.size());
	}
	
	@Test(expected = StockageException.class)
	public void testSaveInvalid() throws StockageException{
		Pizza pizza = new Pizza(0, null, null, null, null);
		pizzaDao.saveNewItem(pizza);
		List<Pizza> pizzas = pizzaDao.findAllItems();		
		//Pr�ferer assertThat � assertEquals
		assertEquals(8, pizzas.size());
		//On peut mettre plusieures conditions les unes � la suite de l'autre
		assertThat(pizzas.size(), allOf(is(8), is(8))); 
	}
	
	/*@Test
	public void testSaveValid() throws StockageException{
		Pizza pizza = new Pizza(0, "TEX", "Texane", 18.00, CategoriePizza.VIANDE);
		pizzaDao.saveNewItem(pizza);
		List<Pizza> pizzas = pizzaDao.findAllItems();		
		assertEquals(9, pizzas.size());
	}*/

}
