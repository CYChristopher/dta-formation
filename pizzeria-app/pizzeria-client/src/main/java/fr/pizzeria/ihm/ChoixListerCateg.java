/**
 * 27 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihm;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.ihmtools.Tools;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
@Controller
public class ChoixListerCateg extends Choix<String, Pizza> {
	
	/**
	 * @param numeroChoix
	 * @param nomChoix
	 * @param dao
	 */
	public ChoixListerCateg(@Value("${listerCateg.num}") Integer numeroChoix, @Value("${listerCateg.nom}") String nomChoix, ItemDao<String, Pizza> dao) {
		super(numeroChoix, nomChoix, dao);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihmtools.Choix#faireUneAction()
	 */
	@Override
	public Boolean faireUneAction() {
		List<Pizza> lesPizzas = this.getItemDao().getItems();
		Map<CategoriePizza, List<Pizza>> categPizza = 
				lesPizzas.stream().collect(Collectors.groupingBy(Pizza::getCategorie));
		new Tools().listPizzasCateg(categPizza);
		System.out.println();
		return true;
	}

}
