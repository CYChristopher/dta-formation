/**
 * 22 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.logging.Level;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.ihm.MenuPizzeria;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzeriaAdminConsoleApp {

	/**
	 * 
	 */
	private PizzeriaAdminConsoleApp() {
		// Pour cacher le constructeur public
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml", daoImpl)) {
			MenuPizzeria menuPizza = context.getBean(MenuPizzeria.class);
			menuPizza.display();
		}
	}
}
