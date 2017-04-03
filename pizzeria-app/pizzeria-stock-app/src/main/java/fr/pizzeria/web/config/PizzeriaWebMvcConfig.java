/**
 * 31 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import fr.pizzeria.controller.IngredientController;

/**
 * @author Christopher CHARLERY
 *
 */
@Configuration
@Import(IngredientController.class)
@EnableTransactionManagement
@EnableJpaRepositories("fr.pizzeria.dao")
@EnableAspectJAutoProxy
@EnableWebMvc
public class PizzeriaWebMvcConfig {
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		return new LocalContainerEntityManagerFactoryBean();
	}

	@Bean
	public ViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}
