/**
 * 29 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author Christopher CHARLERY
 *
 */
@Configuration
@ComponentScan("fr.pizzeria.dao")
public class DaoConfig {

	@Bean
	public DriverManagerDataSource dataSource(){
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(bundle.getString("driver"));
		dataSource.setUrl(bundle.getString("url"));
		dataSource.setUsername(bundle.getString("user"));
		dataSource.setPassword(bundle.getString("password"));
		return dataSource;
	}
	
	@Bean
    public DataSource dataSourceH2() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("init-schema.sql")
                .build();
    }
}
