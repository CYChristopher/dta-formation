package fr.pizzeria.admin.web.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.exception.StockageException;

/**
 * Servlet implementation class DeletePizzaController
 */
@WebServlet(name = "DeletePizzaController", urlPatterns = {"/pizzas/delete"})
public class DeletePizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private PizzaService pizzaService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePizzaController() {
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
			String code = request.getParameter("code");
			pizzaService.deletePizza(code);
			response.sendRedirect(request.getContextPath() + "/pizzas/list");
		} catch (IOException | StockageException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
		}
	}

}
