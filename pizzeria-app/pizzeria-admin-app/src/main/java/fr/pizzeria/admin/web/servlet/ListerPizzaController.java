package fr.pizzeria.admin.web.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;

/**
 * Servlet implementation class ListerPizzaController
 */
@WebServlet(name = "ListerPizzaController", urlPatterns = {"/pizzas/list"})
public class ListerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private PizzaService pizzaService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerPizzaController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("pizzas", pizzaService.findAllPizzas());
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp");
			dispatcher.forward(request, response);
		} catch (IOException | ServletException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
		}
	}
	
}
