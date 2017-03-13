/**
 * 22 Février 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class PizzaDaoImplFile implements ItemDao<String, Pizza> {

	private Logger myLogger = Logger.getLogger(this.getClass().getName());

	private List<Pizza> pizzas;
	private DaoPizzaTools daoTools;

	/**
	 * Implémentation fichier
	 */
	public PizzaDaoImplFile() {

		this.pizzas = new ArrayList<>();
		this.daoTools = new DaoPizzaTools(true);
		findAllItems();
	}

	/**
	 * @return the pizzas
	 */
	@Override
	public List<Pizza> getItems() {
		return pizzas;
	}

	/**
	 * @throws StockageException
	 * 
	 */
	private void generatePizzas() {
		this.daoTools.generatePizzas().forEach(pizza -> {
			try {
				saveInFile(pizza, false, null);
				this.pizzas.add(pizza);
			} catch (StockageException e) {
				myLogger.log(Level.WARNING, e.getMessage(), e);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#findAllPizzas()
	 */
	@Override
	public void findAllItems() {
		this.pizzas = this.daoTools.readFile();
		if (this.pizzas.isEmpty()) {
			generatePizzas();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#saveNewPizza(fr.pizzeria.dao)
	 */
	@Override
	public void saveNewItem(Pizza pizza) throws StockageException {
		this.daoTools.verifySaisie(pizza);
		this.pizzas.add(pizza);
		saveInFile(pizza, false, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#updatePizza(java.lang.String,
	 * fr.pizzeria.dao)
	 */
	@Override
	public void updateItem(String codePizza, Pizza pizza) throws StockageException {
		executeUpdate(codePizza, pizza, true);
	}

	/**
	 * @param codePizza
	 * @param pizza
	 * @param isUpdate
	 * @throws StockageException
	 */
	private void executeUpdate(String codePizza, Pizza pizza, boolean isUpdate) throws StockageException {
		this.daoTools.verifyCode(codePizza);
		this.daoTools.verifySaisie(pizza);
		Optional<Pizza> optPizza = this.pizzas.stream().filter(laPizza -> codePizza.equalsIgnoreCase(laPizza.getCode()))
				.findFirst();
		if (optPizza.isPresent()) {
			if(isUpdate){
				saveInFile(pizza, true, codePizza);
				this.pizzas.set(this.pizzas.indexOf(optPizza.get()), pizza);
			} else{				
				deleteFile(codePizza);
				this.pizzas.remove(optPizza.get());
			}
		} else {
			throw new StockageException("Pizza introuvable ! Veuillez renseigner une pizza dans la liste !");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#deletePizza(java.lang.String)
	 */
	@Override
	public void deleteItem(String codePizza) throws StockageException {
		executeUpdate(codePizza, null, false);
	}

	private void saveInFile(Pizza pizza, boolean rename, String ancienCode) throws StockageException {
		try {
			String cheminFichier = this.daoTools.getDossierData().getCanonicalPath() + "\\" + pizza.getCode() + ".txt";
			Path fichierPizza = Paths.get(cheminFichier);
			List<String> donneesPizza = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			sb.append(pizza.getNom()).append(";").append(pizza.getPrix().toString()).append(";")
					.append(pizza.getCategorie().name());
			donneesPizza.add(sb.toString());
			if (rename) {
				deleteFile(ancienCode);
			}
			Files.write(fichierPizza, donneesPizza, StandardCharsets.UTF_8);
		} catch (IOException e) {
			myLogger.log(Level.WARNING, DaoPizzaTools.MSG_DOSSIER_NON_TROUVE, e);
		}
	}

	private void deleteFile(String code) throws StockageException {
		File fichier = new File(this.daoTools.getDossierData() + "\\" + code + ".txt");
		if (!fichier.delete()) {
			throw new StockageException(
					"Impossible de supprimer le fichier " + this.daoTools.getDossierData() + "\\" + code + ".txt !");
		}
	}

}
