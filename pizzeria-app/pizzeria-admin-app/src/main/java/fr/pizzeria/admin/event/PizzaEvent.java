/**
 * 23 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.admin.event;

import java.time.ZonedDateTime;

import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzaEvent {
	private Pizza pizza;
	private Pizza modifiedPizza;
	private ZonedDateTime heure;
	private PizzaEventType type;
	
	/**
	 * @param pizza
	 * @param heure
	 */
	public PizzaEvent(Pizza pizza, ZonedDateTime heure, PizzaEventType type) {
		this.pizza = pizza;
		this.heure = heure;
		this.type = type;
	}
	
	/**
	 * @return the pizza
	 */
	public Pizza getPizza() {
		return pizza;
	}
	/**
	 * @param pizza the pizza to set
	 */
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	/**
	 * @return the heure
	 */
	public ZonedDateTime getHeure() {
		return heure;
	}
	/**
	 * @param heure the heure to set
	 */
	public void setHeure(ZonedDateTime heure) {
		this.heure = heure;
	}

	/**
	 * @return the type
	 */
	public PizzaEventType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(PizzaEventType type) {
		this.type = type;
	}

	/**
	 * @return the modifiedPizza
	 */
	public Pizza getModifiedPizza() {
		return modifiedPizza;
	}

	/**
	 * @param modifiedPizza the modifiedPizza to set
	 */
	public void setModifiedPizza(Pizza modifiedPizza) {
		this.modifiedPizza = modifiedPizza;
	}
}
