/**
 * 23 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.admin.metier;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import fr.pizzeria.admin.event.PizzaEvent;

/**
 * @author Christopher CHARLERY
 *
 */
@ApplicationScoped
public class PizzaStatistiquesService {
	private List<PizzaEvent> events;
	
	@ApplicationScoped
	@PostConstruct
	public void init(){
		this.events = new ArrayList<>();
	}
	
	/**
	 * Ecoute et stocke les différents évenements sur une pizza
	 * @param event
	 */
	public void listenPizzaEvent(@Observes PizzaEvent event){
		this.events.add(event);
	}

	/**
	 * @return the events
	 */
	public List<PizzaEvent> getEvents() {
		return events;
	}
}
