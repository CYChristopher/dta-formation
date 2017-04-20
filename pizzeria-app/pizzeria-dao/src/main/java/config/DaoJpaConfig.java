/**
 * 29 mars 2017 Christopher CHARLERY
 */
package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.SpringPizzaDaoJpa;

/**
 * @author Christopher CHARLERY
 *
 */
@Configuration
@Import(SpringPizzaDaoJpa.class)
@ComponentScan("fr.pizzeria.aspects")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class DaoJpaConfig {

	@Bean
	@Qualifier("emf")
	public LocalEntityManagerFactoryBean emf() {
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("pizzeria");
		return emf;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

}
