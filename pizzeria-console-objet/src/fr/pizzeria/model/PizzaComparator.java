/**
 * 27 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

import java.util.Comparator;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzaComparator implements Comparator<Pizza>{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Pizza p1, Pizza p2) {
		int result = 0;
		if(p1.getPrix() > p2.getPrix()){
			result = 1;
		} else if (p1.getPrix() == p2.getPrix()){
			result = 0;
		} else {
			result = -1;
		}
		return result;
	}

}
