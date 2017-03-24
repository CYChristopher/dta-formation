/**
 * 9 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaValidator;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzaDaoImplDB implements ItemDao<String, Pizza> {

	private Logger myLogger = Logger.getLogger(this.getClass().getName());

	private List<Pizza> pizzas;
	private DaoPizzaTools daoTools;
	private ResourceBundle bundle;
	private String url;
	private String user;
	private String password;
	private PizzaValidator validator;

	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public PizzaDaoImplDB() throws ClassNotFoundException, SQLException {
		this.pizzas = new ArrayList<>();
		this.daoTools = new DaoPizzaTools();
		this.bundle = ResourceBundle.getBundle("jdbc");
		Class.forName(this.bundle.getString("driver"));
		this.url = this.bundle.getString("url");
		this.user = this.bundle.getString("user");
		this.password = this.bundle.getString("password");
		findAllItems();
	}

	/**
	 * @return the pizzas
	 */
	@Override
	public List<Pizza> getItems() {
		return pizzas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#findAllItems()
	 */
	@Override
	public void findAllItems() {
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM pizza");
				ResultSet resultats = pStatement.executeQuery();) {
			while (resultats.next()) {
				Integer id = resultats.getInt("ID_Pizza");
				String categorie = resultats.getString("Categorie");
				String code = resultats.getString("Code");
				String nom = resultats.getString("Nom");
				String description = resultats.getString("Description");
				BigDecimal prix = resultats.getBigDecimal("Prix");

				Pizza newPizza = new Pizza(id, code, nom, description, prix, categorie);
				this.pizzas.add(newPizza);
			}
		} catch (SQLException e) {
			myLogger.log(Level.WARNING, e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#saveNewItem(java.lang.Object)
	 */
	@Override
	public void saveNewItem(Pizza item) throws StockageException {

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pStatement = connection.prepareStatement(
						"" + "INSERT INTO pizza (ID_Pizza, Categorie, Code, Nom, Description, Prix, URL_image) "
								+ "VALUES(?, ?, ?, ?, ?, ?, ?)");) {
			this.validator.verifySaisie(item);
			pStatement.setString(1, null);
			pStatement.setString(2, item.getCategorie().name());
			pStatement.setString(3, item.getCode());
			pStatement.setString(4, item.getNom());
			pStatement.setString(5, item.getDescription());
			pStatement.setBigDecimal(6, item.getPrix());
			pStatement.setString(7, null);
			pStatement.execute();
			this.pizzas.add(item);
		} catch (SQLException e) {
			myLogger.log(Level.WARNING, e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#updateItem(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public void updateItem(String codePizza, Pizza item) throws StockageException {
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pStatement = connection.prepareStatement(
						"UPDATE pizza SET Code=?, Nom=?, Description=?, Prix=? " + "WHERE ID_Pizza=?");) {
			this.validator.verifyCode(codePizza);
			this.validator.verifySaisie(item);
			Pizza laPizza = getPizza(codePizza);
			if (laPizza != null) {
				pStatement.setString(1, item.getCode());
				pStatement.setString(2, item.getNom());
				pStatement.setString(3, item.getDescription());
				pStatement.setBigDecimal(4, item.getPrix());
				pStatement.setInt(5, laPizza.getId());
				pStatement.executeUpdate();

				int index = this.pizzas.indexOf(laPizza);
				this.pizzas.get(index).setCode(item.getCode());
				this.pizzas.get(index).setNom(item.getNom());
				this.pizzas.get(index).setDescription(item.getDescription());
				this.pizzas.get(index).setPrix(item.getPrix());
			} else {
				throw new StockageException("Aucune pizza trouvée !");
			}
		} catch (SQLException e) {
			myLogger.log(Level.WARNING, e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#deleteItem(java.lang.Object)
	 */
	@Override
	public void deleteItem(String codePizza) throws StockageException {
		
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pStatement = connection.prepareStatement("DELETE FROM pizza WHERE ID_Pizza=?");) {
			this.validator.verifyCode(codePizza);
			Pizza laPizza = getPizza(codePizza);
			if (laPizza != null) {
				pStatement.setInt(1, laPizza.getId());
				pStatement.executeUpdate();
				this.pizzas.remove(laPizza);
			} else {
				throw new StockageException("Aucune pizza trouvée !");
			}
		} catch (SQLException e) {
			myLogger.log(Level.WARNING, e.getMessage(), e);
		}
	}

	private Pizza getPizza(String code) {
		Pizza laPizza = null;
		Optional<Pizza> optPizza = this.pizzas.stream().filter(pizza -> code.equalsIgnoreCase(pizza.getCode()))
				.findFirst();
		if (optPizza.isPresent()) {
			laPizza = optPizza.get();
		}
		return laPizza;
	}

	/**
	 * Importation des données depuis un fichier
	 */
	public void importPizzas() {
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM WHERE ID_Pizza=?");) {
			List<Pizza> list = this.daoTools.readFile();
			list.forEach(pizzaInFile -> {
				// Implémentation à faire
			});
		} catch (SQLException e) {
			myLogger.log(Level.WARNING, e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.ItemDao#find(java.lang.Object)
	 */
	@Override
	public Pizza find(String code) {
		return null;
	}

}
