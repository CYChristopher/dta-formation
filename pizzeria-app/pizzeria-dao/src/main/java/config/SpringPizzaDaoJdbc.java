/**
 * 29 mars 2017 Christopher CHARLERY
 */
package config;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import fr.pizzeria.dao.ItemDao;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
@Repository
public class SpringPizzaDaoJdbc implements ItemDao<String, Pizza> {

	private JdbcTemplate jdbcTemplate;
	private List<Pizza> pizzas;

	/**
	 * Utilisation de la base de données MySql
	 */
	@Autowired
	public SpringPizzaDaoJdbc(@Qualifier("datasource") DriverManagerDataSource dataSource) {
		this.pizzas = new ArrayList<>();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Utilisation de la base de données H2
	 */
	//@Autowired A utiliser selon la base de données que l'on veut utiliser
	public SpringPizzaDaoJdbc(@Qualifier("datasourceH2") DataSource dataSourceH2) {
		this.pizzas = new ArrayList<>();
		this.jdbcTemplate = new JdbcTemplate(dataSourceH2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#getItems()
	 */
	@Override
	public List<Pizza> getItems() {
		return this.pizzas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#findAllItems()
	 */
	@Override
	public void findAllItems() {
		this.pizzas.clear();
		String sql = "SELECT * FROM pizza";
		this.jdbcTemplate.queryForList(sql).forEach(map -> {
			Pizza pizza =new Pizza();
			pizza.setId((Integer) map.get("id"));
			pizza.setCategorie((String) map.get("categorie"));
			pizza.setCode((String) map.get("code"));
			pizza.setDescription((String) map.get("description"));
			pizza.setNom((String) map.get("nom"));
			pizza.setPrix((BigDecimal) map.get("prix"));
			pizza.setUrlImage((String)  map.get("url_image"));
			this.pizzas.add(pizza);
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#find(java.lang.Object)
	 */
	@Override
	public Pizza find(String code) {
		String sql = "SELECT * FROM pizza WHERE code=?";
		return this.jdbcTemplate.queryForObject(sql, new PizzaMapper(), code.toUpperCase());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#saveNewItem(java.lang.Object)
	 */
	@Override
	public void saveNewItem(Pizza item) {
		String sql = "INSERT INTO pizza (id, categorie, code, description, nom, prix, url_image) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, null, item.getCategorie().name(), item.getCode(), item.getDescription(),
				item.getNom(), item.getPrix(), item.getUrlImage());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#updateItem(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public void updateItem(String index, Pizza item) {
		String sql = "UPDATE pizza SET categorie=?, code=?, description=?, nom=?, prix=?, url_image=? WHERE id=?";
		this.jdbcTemplate.update(sql, item.getCategorie().name(), item.getCode(), item.getDescription(), item.getNom(),
				item.getPrix(), item.getUrlImage(), item.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#deleteItem(java.lang.Object)
	 */
	@Override
	public void deleteItem(String index) {
		String sql = "DELETE FROM pizza WHERE code=?";
		this.jdbcTemplate.update(sql, index);
	}

	private class PizzaMapper implements RowMapper<Pizza> {
		@Override
		public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pizza p = new Pizza();
			p.setId(rs.getInt("id"));
			p.setCategorie(rs.getString("categorie"));
			p.setCode(rs.getString("code"));
			p.setDescription(rs.getString("description"));
			p.setNom(rs.getString("nom"));
			p.setPrix(rs.getString("prix"));
			p.setUrlImage(rs.getString("url_image"));
			return p;
		}
	}
}
