package fr.pizzeria.admin.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.dao.PizzaDaoJpa;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class PizzaServletWebApi
 */
@WebServlet(name = "PizzaServletWebApi", urlPatterns = {"/api/servlet/pizzas"})
public class PizzaServletWebApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ItemDao<String, Pizza> dao = new PizzaDaoJpa();

	/**
	 * Default constructor.
	 */
	public PizzaServletWebApi() {
		//
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Pizza> pizzas = dao.getItems();
			response.getWriter().append(pizzas.toString());
		} catch (IOException e) {
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
		try{
			String nom = request.getParameter("nom");
			String code = request.getParameter("code");
			BigDecimal prix = BigDecimal.valueOf(Double.parseDouble(request.getParameter("prix")));
			String categ = request.getParameter("categ");
			Pizza pizza = new Pizza(code, nom, null, prix, categ);
			dao.saveNewItem(pizza);
			response.setStatus(201);
		}catch(NumberFormatException | StockageException e){
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String id = request.getParameter("id");
			String code = request.getParameter("code");
			String nom = request.getParameter("nom");
			BigDecimal prix = BigDecimal.valueOf(Double.parseDouble(request.getParameter("prix")));
			String categ = request.getParameter("categ");
			Pizza pizza = new Pizza(code, nom, null, prix, categ);
			dao.updateItem(id, pizza);
		}catch(NumberFormatException |StockageException e){
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 
	}

}
