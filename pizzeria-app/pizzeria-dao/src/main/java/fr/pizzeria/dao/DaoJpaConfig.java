/**
 * 29 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Christopher CHARLERY
 *
 */
@Configuration
@ComponentScan("fr.pizzeria.dao")
@EnableTransactionManagement
public class DaoJpaConfig {

	@Bean
	public LocalEntityManagerFactoryBean localEntityManagerFactoryBean() {
		return new LocalEntityManagerFactoryBean();
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new JpaTransactionManager();
	}

}
