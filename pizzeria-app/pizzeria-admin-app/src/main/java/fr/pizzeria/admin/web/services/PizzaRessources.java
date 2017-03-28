/**
 * 27 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.admin.web.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
@Path("/pizzas")
public class PizzaRessources {
	@Inject private PizzaService pizzaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> list(){
		return pizzaService.findAllPizzas();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void add(Pizza pizza){
		pizzaService.savePizza(pizza);
	}
	
	@PUT
	@Path("/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(@PathParam("code") String ancienCode, Pizza pizza){
		pizzaService.updatePizza(ancienCode, pizza);
	}

	@DELETE
	@Path("/{code}")
	public void add(@PathParam("code") String code){
		pizzaService.deletePizza(code);
	}
}
