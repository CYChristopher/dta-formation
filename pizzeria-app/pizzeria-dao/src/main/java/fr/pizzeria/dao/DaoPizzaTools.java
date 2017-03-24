/**
 * 10 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public class DaoPizzaTools {

	public static final String MSG_DOSSIER_NON_TROUVE = "Le dossier data\\pizza est introuvable !";
	private Logger myLogger = Logger.getLogger(this.getClass().getName());

	private String cheminDossier;
	private File dossierData;

	/**
	 * 
	 */
	public DaoPizzaTools() {
		// Constructeur par default
	}

	/**
	 * @param useFile
	 */
	public DaoPizzaTools(boolean useFile) {
		if (useFile) {
			try {
				this.cheminDossier = new File("").getCanonicalPath();
				this.dossierData = new File(cheminDossier + "\\data\\pizzas");
			} catch (IOException e) {
				this.myLogger.log(Level.WARNING, DaoPizzaTools.MSG_DOSSIER_NON_TROUVE, e);
			}
		}
	}

	/**
	 * @return the cheminDossier
	 */
	public String getCheminDossier() {
		return cheminDossier;
	}

	/**
	 * @param cheminDossier
	 *            the cheminDossier to set
	 */
	public void setCheminDossier(String cheminDossier) {
		this.cheminDossier = cheminDossier;
	}

	/**
	 * @return the dossierData
	 */
	public File getDossierData() {
		return dossierData;
	}

	/**
	 * @param dossierData
	 *            the dossierData to set
	 */
	public void setDossierData(File dossierData) {
		this.dossierData = dossierData;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Pizza> generatePizzas(){
		List<Pizza> list = new ArrayList<>();
		Pizza peperoni = new Pizza(null, "PEP", "Pépéroni", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE);
		list.add(peperoni);

		Pizza margherita = new Pizza(null, "MAR", "Margherita", BigDecimal.valueOf(14.00), CategoriePizza.VEGETARIENNE);
		list.add(margherita);

		Pizza laReine = new Pizza(null, "REI", "La Reine", BigDecimal.valueOf(11.50), CategoriePizza.VIANDE);
		list.add(laReine);

		Pizza la4Fromages = new Pizza(null, "FRO", "La 4 fromages", BigDecimal.valueOf(12.00), CategoriePizza.VEGETARIENNE);
		list.add(la4Fromages);

		Pizza laCannibale = new Pizza(null, "CAN", "La cannibale", BigDecimal.valueOf(12.50), CategoriePizza.VIANDE);
		list.add(laCannibale);

		Pizza laSavoyarde = new Pizza(null, "SAV", "La savoyarde", BigDecimal.valueOf(13.00), CategoriePizza.VIANDE);
		list.add(laSavoyarde);

		Pizza lOrientale = new Pizza(null, "ORI", "L'orientale", BigDecimal.valueOf(13.50), CategoriePizza.VIANDE);
		list.add(lOrientale);

		Pizza lIndienne = new Pizza(null, "IND", "L'indienne", BigDecimal.valueOf(14.00), CategoriePizza.VIANDE);
		list.add(lIndienne);
		
		return list;
	}

	/**
	 * 
	 * @return
	 */
	public List<Pizza> readFile() {
		List<Pizza> list = new ArrayList<>();
		try {
			String[] fichiers = this.dossierData.list();
			for (int i = 0; i < fichiers.length; i++) {
				InputStream flux = new FileInputStream(this.dossierData + "\\" + fichiers[i]);
				InputStreamReader lecteur = new InputStreamReader(flux, StandardCharsets.UTF_8);
				BufferedReader buff = new BufferedReader(lecteur);
				String donneesLigne = buff.readLine();
				String codePizza = fichiers[i].split(".txt")[0];
				String[] donneesTab = donneesLigne.split(";");
				Pizza pizza = new Pizza(null, codePizza, donneesTab[0],
						BigDecimal.valueOf(Double.parseDouble(donneesTab[1])), CategoriePizza.valueOf(donneesTab[2]));
				list.add(pizza);
				buff.close();
				flux.close();
			}
		} catch (IOException e) {
			myLogger.log(Level.WARNING, DaoPizzaTools.MSG_DOSSIER_NON_TROUVE, e);
		}
		return list;
	}
}
