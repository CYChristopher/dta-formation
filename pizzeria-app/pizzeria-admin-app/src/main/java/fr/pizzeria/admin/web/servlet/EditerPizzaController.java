package fr.pizzeria.admin.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
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
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class EditerPizzaController
 */
@WebServlet(name = "EditerPizzaController", urlPatterns = {"/pizzas/edit"})
public class EditerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private PizzaService pizzaService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditerPizzaController() {
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
			String ancienCode = request.getParameter("code");
			Pizza pizza = pizzaService.findPizza(ancienCode);
			request.setAttribute("pizza", pizza);
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp");
			dispatcher.forward(request, response);
		} catch (IOException | ServletException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nom = request.getParameter("nom");
			String ancienCode = request.getParameter("anciencode").toUpperCase();
			String code = request.getParameter("code").toUpperCase();
			String categorie = request.getParameter("categorie");
			String description = request.getParameter("description");
			BigDecimal prix = BigDecimal.valueOf(Double.parseDouble(request.getParameter("prix")));
			Pizza pizza = new Pizza(code, nom, description, prix, categorie);
			pizzaService.updatePizza(ancienCode, pizza);
			response.sendRedirect(request.getContextPath() + "/pizzas/list");
		} catch (IOException | StockageException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
		}
	}
}
