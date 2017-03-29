/**
 * 22 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.logging.Level;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.ihm.MenuPizzeria;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzeriaClientConsoleApp {

	/**
	 * 
	 */
	private PizzeriaClientConsoleApp() {
		// Pour cacher le constructeur public
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class)) {
			MenuPizzeria menuPizza = context.getBean(MenuPizzeria.class);
			menuPizza.display();
		}
	}
}
