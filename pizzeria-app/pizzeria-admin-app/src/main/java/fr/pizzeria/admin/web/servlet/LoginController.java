package fr.pizzeria.admin.web.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(name = "LoginController", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String user = (String) request.getSession().getAttribute("user");
			if (user == null) {
				String msg = "Vous devez être connecté pour pouvoir accéder à cette fonctionnalité !";
				request.setAttribute("msg", msg);
				RequestDispatcher dispatcher = this.getServletContext()
						.getRequestDispatcher("/WEB-INF/views/pizzas/login.jsp");
				dispatcher.forward(request, response);
			}else{
				response.sendRedirect(request.getContextPath() + "/accueil");
			}
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
			String user = request.getParameter("email");
			String password = request.getParameter("password");
			if ("admin@pizzeria.fr".equals(user) && "admin".equals(password)) {
				request.getSession().setAttribute("user", user);
				HttpSession session = request.getSession();
				String url = (String) session.getAttribute("url");
				if (url != null) {
					session.setAttribute("url", null);
					response.sendRedirect(url);
				} else {
					response.sendRedirect(request.getContextPath() + "/accueil");
				}
			} else {
				String msg = "Vos identifiants de connexion ne sont pas bons !";
				request.setAttribute("msg", msg);
				RequestDispatcher dispatcher = this.getServletContext()
						.getRequestDispatcher("/WEB-INF/views/pizzas/login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (IOException | ServletException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
		}
	}

}
