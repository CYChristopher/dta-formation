/**
 * 1 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

import java.math.BigDecimal;

/**
 * @author Christopher CHARLERY
 *
 */
@FunctionalInterface
public interface CompteStat {
	/**
	 * 
	 * @return
	 */
	BigDecimal getSolde();

}
