/**
 * 27 f�vr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.pizzeria.dao.IItemDao;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.ihmtools.PizzasTools;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChoixListerCateg extends Choix<String, Pizza> {

	
	
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 * @param dao
	 */
	public ChoixListerCateg(Integer numeroChoix, String nomChoix, IItemDao<String, Pizza> dao) {
		super(numeroChoix, nomChoix, dao);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihmtools.Choix#faireUneAction()
	 */
	@Override
	public Boolean faireUneAction() {
		List<Pizza> lesPizzas = this.getItemDao().findAllItems();
		Map<CategoriePizza, List<Pizza>> categPizza = 
				lesPizzas.stream().collect(Collectors.groupingBy(Pizza::getCategorie));
		new PizzasTools().listPizzasCateg(categPizza);
		System.out.println();
		return true;
	}

}
