/**
 * 30 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.SpringPizzaDaoDataJpa;

/**
 * @author Christopher CHARLERY
 *
 */
@Configuration
@Import(SpringPizzaDaoDataJpa.class)
@ComponentScan("fr.pizzeria.aspects")
@EnableTransactionManagement
@EnableJpaRepositories("fr.pizzeria.dao")
@EnableAspectJAutoProxy
public class DaoDataJpaConfig {

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		
		return txManager;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		
		
		return new LocalContainerEntityManagerFactoryBean();
	}
	
}
