/**
 * 27 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import fr.pizzeria.dao.IItemDao;
import fr.pizzeria.ihmtools.Choix;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class ChoixPizzaMax extends Choix<String, Pizza> {

	/**
	 * @param numeroChoix
	 * @param nomChoix
	 * @param dao
	 * @param scan
	 */
	public ChoixPizzaMax(Integer numeroChoix, String nomChoix, IItemDao<String, Pizza> dao, Scanner scan) {
		super(numeroChoix, nomChoix, dao, scan);
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.ihmtools.Choix#faireUneAction()
	 */
	@Override
	public Boolean faireUneAction() {
		List<Pizza> lesPizzas = this.getItemDao().findAllItems();
		Optional<Pizza> laPizza = lesPizzas.stream().collect(Collectors.maxBy(Comparator.comparing(Pizza::getPrix)));
		if(laPizza.isPresent()){
			lesPizzas.forEach(pizza -> {
				if(pizza.getPrix() == laPizza.get().getPrix()){
					System.out.println(pizza.toString());
				}
			});
			System.out.println();
		}
		return true;
	}

}
