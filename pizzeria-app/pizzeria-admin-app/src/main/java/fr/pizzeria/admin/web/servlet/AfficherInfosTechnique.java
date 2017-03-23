package fr.pizzeria.admin.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfficherInfosTechnique
 */
@WebServlet(name = "AfficherInfosTechnique", urlPatterns = {"/technique"})
public class AfficherInfosTechnique extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficherInfosTechnique() {
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
			List<String> timeExe = (List<String>) this.getServletContext().getAttribute("timeExe");
			Integer compteur = (Integer) this.getServletContext().getAttribute("compteur");
			request.setAttribute("times", timeExe);
			request.setAttribute("compteur", compteur);
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/pizzas/infosTechnique.jsp");
			dispatcher.forward(request, response);
		} catch (IOException | ServletException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
		}
	}

}
