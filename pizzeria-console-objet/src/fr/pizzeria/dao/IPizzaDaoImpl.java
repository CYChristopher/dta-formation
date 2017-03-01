/**
 * 22 févr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	private String cheminDossier;
	private File dossierData;

	/**
	 * 
	 * @param taille
	 */
	public IPizzaDaoImpl() {
		try {
			this.pizzas = new ArrayList<Pizza>();
			cheminDossier = new File("").getCanonicalPath();
			dossierData = new File(cheminDossier + "\\data\\pizzas");
			initializeList();
		} catch (IOException e) {
			System.out.println("Le dossier data\\pizza est introuvable !");
		}
	}

	/**
	 * Initialise le tableau des pizzas
	 */
	public void initializeList() {
		try {
			boolean isCreated = dossierData.mkdirs();
			if (!isCreated) {
				String[] fichiers = dossierData.list();
				for (int i = 0; i < fichiers.length; i++) {
					InputStream flux = new FileInputStream(dossierData + "\\" + fichiers[i]);
					InputStreamReader lecteur = new InputStreamReader(flux, StandardCharsets.UTF_8);
					BufferedReader buff = new BufferedReader(lecteur);
					String donneesLigne = buff.readLine();
					String codePizza = fichiers[i].split(".txt")[0];
					String[] donneesTab = donneesLigne.split(";");
					Pizza pizza = new Pizza(this.pizzas.size(), codePizza, donneesTab[0],
							Double.parseDouble(donneesTab[1]), CategoriePizza.valueOf(donneesTab[2]));
					this.pizzas.add(pizza);
					buff.close();
				}
			} else {
				generatePizzas();
			}
		} catch (IOException e) {
			System.out.println("Le dossier data\\pizza est introuvable !");
		}
	}

	/**
	 * 
	 */
	private void generatePizzas() {
		Pizza peperoni = new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE);
		this.pizzas.add(peperoni);
		saveInFile(peperoni, false, null);

		Pizza margherita = new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.VIANDE);
		this.pizzas.add(margherita);
		saveInFile(margherita, false, null);

		Pizza laReine = new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.VIANDE);
		this.pizzas.add(laReine);
		saveInFile(laReine, false, null);

		Pizza la4Fromages = new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE);
		this.pizzas.add(la4Fromages);
		saveInFile(la4Fromages, false, null);

		Pizza laCannibale = new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE);
		this.pizzas.add(laCannibale);
		saveInFile(laCannibale, false, null);

		Pizza laSavoyarde = new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE);
		this.pizzas.add(laSavoyarde);
		saveInFile(laSavoyarde, false, null);

		Pizza lOrientale = new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.VIANDE);
		this.pizzas.add(lOrientale);
		saveInFile(lOrientale, false, null);

		Pizza lIndienne = new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.VIANDE);
		this.pizzas.add(lIndienne);
		saveInFile(lIndienne, false, null);
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
		if (pizza.getCategorie() == null) {
			throw new StockageException("Vous devez choisir une catégorie de pizza !");
		}
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
		this.pizzas.forEach((laPizza) -> {
			if (laPizza.getCode().equalsIgnoreCase(codePizza)) {
				laPizza.setCode(pizza.getCode());
				laPizza.setNom(pizza.getNom());
				laPizza.setPrix(pizza.getPrix());
				pizzaInList = true;
				saveInFile(laPizza, true, codePizza);
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
		Iterator<Pizza> iterator = this.pizzas.iterator();
		while (iterator.hasNext()) {
			Pizza unePizza = iterator.next();
			if (unePizza.getCode().equalsIgnoreCase(codePizza)) {
				pizzas.remove(unePizza);
				deleteFile(unePizza.getCode());
				pizzaInList = true;
				break;
			}
		}
		if (!pizzaInList) {
			throw new StockageException("Pizza introuvable ! Veuillez renseigner une pizza dans la liste !");
		}
	}

	private void saveInFile(Pizza pizza, boolean rename, String ancienCode) {
		try {
			String cheminFichier = dossierData.getCanonicalPath() + "\\" + pizza.getCode() + ".txt";
			Path fichierPizza = Paths.get(cheminFichier);
			List<String> donneesPizza = new ArrayList<String>();
			StringBuilder sb = new StringBuilder();
			sb.append(pizza.getNom()).append(";").append(Double.toString(pizza.getPrix())).append(";")
					.append(pizza.getCategorie().name());
			donneesPizza.add(sb.toString());
			if (rename) {
				deleteFile(ancienCode);
			}
			Files.write(fichierPizza, donneesPizza, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Le dossier data\\pizza est introuvable !");
		}
	}

	private void deleteFile(String code) {
		File fichier = new File(dossierData + "\\" + code + ".txt");
		fichier.delete();
	}

}
