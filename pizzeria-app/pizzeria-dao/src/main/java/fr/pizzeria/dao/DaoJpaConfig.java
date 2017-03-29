/**
 * 29 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Christopher CHARLERY
 *
 */
@Configuration
@Import(SpringPizzaDaoJpa.class)
@EnableTransactionManagement
public class DaoJpaConfig {

	@Bean
	public LocalEntityManagerFactoryBean emf() {
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("pizzeria");
		return emf;
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new JpaTransactionManager();
	}

}
