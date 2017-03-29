/**
 * 28 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.ihmtools.Menu;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
@Configuration
@ComponentScan({"fr.pizzeria.ihm", "fr.pizzeria.ihmtools"})
public class PizzeriaAppSpringConfig {

		@Bean
		public Scanner scanner(){
			return new Scanner(System.in);
		}
		
		@Bean 
		public Menu menu(){
			return new Menu("***** Pizzeria Client *****");
		}
		
		@Bean
		public ItemDao<String, Pizza> dao(){
			ItemDao<String, Pizza> instanceDaoImpl = null;
			try {
				ResourceBundle bundle = ResourceBundle.getBundle("application");
				String daoImpl = bundle.getString("service.impl");
				instanceDaoImpl = (ItemDao<String, Pizza>) Class.forName(daoImpl).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				Logger.getLogger(PizzeriaAppSpringConfig.class.getName()).log(Level.WARNING, e.getMessage(), e);
			}
			return instanceDaoImpl;
		}
	
		
		@Bean
		public PropertyPlaceholderConfigurer config(){
			PropertyPlaceholderConfigurer config = new PropertyPlaceholderConfigurer();
			config.setLocation(new ClassPathResource("application.properties"));
			return config;
		}
}
