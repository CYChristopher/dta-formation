package fr.pizzeria.admin.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.DaoTool;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class NewPizzaController
 */
@WebServlet(name = "NewPizzaController", urlPatterns = { "/pizzas/new" })
public class NewPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewPizzaController() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/pizzas/ajouterPizza.jsp");
			dispatcher.forward(req, resp);
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
			String code = request.getParameter("code").toUpperCase();
			String categorie = request.getParameter("categorie");
			String description = request.getParameter("description");
			BigDecimal prix = BigDecimal.valueOf(Double.parseDouble(request.getParameter("prix")));
			Pizza pizza = new Pizza(code, nom, description, prix, categorie);
			DaoTool.daoJpa.saveNewItem(pizza);
			response.sendRedirect(request.getContextPath() + "/pizzas/list");
		} catch (IOException | StockageException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
		}
	}

}
