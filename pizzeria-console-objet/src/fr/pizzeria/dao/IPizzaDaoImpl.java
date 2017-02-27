/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class IPizzaDaoImpl implements IItemDao<String, Pizza> {

	private List<Pizza> pizzas;
	private Boolean pizzaInList = false;

	/**
	 * 
	 * @param taille
	 */
	public IPizzaDaoImpl() {
		this.pizzas = new ArrayList<Pizza>();
	}

	/**
	 * Initialise le tableau des pizzas
	 */
	public void initializeList() {

		Pizza peperoni = new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE);
		this.pizzas.add(peperoni);
		//saveInFile(peperoni);

		Pizza margherita = new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.VIANDE);
		this.pizzas.add(margherita);
		//saveInFile(margherita);

		Pizza laReine = new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.VIANDE);
		this.pizzas.add(laReine);
		//saveInFile(laReine);

		Pizza la4Fromages = new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE);
		this.pizzas.add(la4Fromages);
		//saveInFile(la4Fromages);

		Pizza laCannibale = new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE);
		this.pizzas.add(laCannibale);
		//saveInFile(laCannibale);

		Pizza laSavoyarde = new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE);
		this.pizzas.add(laSavoyarde);
		//saveInFile(laSavoyarde);

		Pizza lOrientale = new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.VIANDE);
		this.pizzas.add(lOrientale);
		//saveInFile(lOrientale);

		Pizza lIndienne = new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.VIANDE);
		this.pizzas.add(lIndienne);
		//saveInFile(lIndienne);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllItems() {
		return pizzas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#saveNewPizza(fr.pizzeria.dao)
	 */
	@Override
	public void saveNewItem(Pizza pizza) throws StockageException {
		if (pizza.getCode() == null || pizza.getCode().equalsIgnoreCase("")) {
			throw new StockageException("Le code de la pizza est incorrect !");
		}
		if (pizza.getNom() == null || pizza.getNom().equalsIgnoreCase("")) {
			throw new StockageException("Le nom de la pizza est incorrect !");
		}
		if(pizza.getCategorie() == null){
			throw new StockageException("Vous devez choisir une catégorie de pizza !");
		}
		this.pizzas.add(pizza);
		saveInFile(pizza);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.dao.IItemDao#updatePizza(java.lang.String,
	 * fr.pizzeria.dao)
	 */
	@Override
	public void updateItem(String codePizza, Pizza pizza) throws StockageException {
		if (codePizza == null || codePizza.equalsIgnoreCase("")) {
			throw new StockageException("Le code de la pizza sélectionnée est incorrect !");
		}
		if (pizza.getCode() == null || pizza.getCode().equalsIgnoreCase("")) {
			throw new StockageException("Le code modifié de la pizza est incorrect !");
		}
		if (pizza.getNom() == null || pizza.getNom().equalsIgnoreCase("")) {
			throw new StockageException("Le nom modifié de la pizza est incorrect !");
		}
		pizzaInList = false;
		this.pizzas.forEach(new Consumer<Pizza>() {
			@Override
			public void accept(Pizza laPizza) {
				if (laPizza.getCode().equalsIgnoreCase(codePizza)) {
					laPizza.setCode(pizza.getCode());
					laPizza.setNom(pizza.getNom());
					laPizza.setPrix(pizza.getPrix());
					pizzaInList = true;
				}
			}
		});
		if (!pizzaInList) {
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
		if (codePizza == null || codePizza.equalsIgnoreCase("")) {
			throw new StockageException("Le code de la pizza sélectionnée est incorrect !");
		}
		pizzaInList = false;
		this.pizzas.forEach(new Consumer<Pizza>() {
			@Override
			public void accept(Pizza laPizza) {
				pizzas.remove(laPizza);
				pizzaInList = true;
			}
		});
		if (!pizzaInList) {
			throw new StockageException("Pizza introuvable ! Veuillez renseigner une pizza dans la liste !");
		}
	}
	
	private void saveInFile(Pizza pizza){
		try {
			String cheminDossier = new File("").getCanonicalPath();
			File dossier = new File(cheminDossier + "\\data");
			dossier.mkdirs();
			String cheminFichier = dossier.getCanonicalPath() + "\\" + pizza.getCode() + ".txt";
			Path fichierPizza = Paths.get(cheminFichier);
			List<String> donneesPizza = new ArrayList<String>();
			StringBuilder sb = new StringBuilder();
			sb.append(pizza.getNom())
			.append(";")
			.append(Double.toString(pizza.getPrix()))
			.append(";")
			.append(pizza.getCategorie().toString().toUpperCase());
			donneesPizza.add(sb.toString());
			Files.write(fichierPizza, donneesPizza, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
