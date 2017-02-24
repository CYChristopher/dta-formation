/**
 * 22 f�vr. 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihmtools;

import java.util.Scanner;

import fr.pizzeria.dao.IItemDao;

/**
 * @author Christopher CHARLERY
 * @param <I> 
 * @param <G>
 *
 */
public abstract class Choix<G, I> {
	
	private Integer numeroChoix;
	private String nomChoix;
	private IItemDao<G, I> itemDao;
	private Scanner sc;
	
	/**
	 * Cr�e un nouvel item d'un menu
	 * @param numeroChoix Position dans le menu
	 * @param nomChoix Nom du choix
	 */
	public Choix(Integer numeroChoix, String nomChoix) {
		super();
		this.setNumeroChoix(numeroChoix);
		this.setNomChoix(nomChoix);
	}
	
	/**
	 * 
	 * @param numeroChoix
	 * @param nomChoix
	 * @param scan
	 */
	public Choix(Integer numeroChoix, String nomChoix, Scanner scan) {
		this(numeroChoix, nomChoix);
		this.setSc(scan);
	}
	
	/**
	 * 
	 * @param numeroChoix
	 * @param nomChoix
	 * @param dao
	 */
	public Choix(Integer numeroChoix, String nomChoix, IItemDao<G, I> dao) {
		this(numeroChoix, nomChoix);
		this.setItemDao(dao);
	}
	
	/**
	 * 
	 * @param numeroChoix
	 * @param nomChoix
	 * @param dao
	 * @param scan
	 */
	public Choix(Integer numeroChoix, String nomChoix, IItemDao<G, I> dao, Scanner scan) {
		this(numeroChoix, nomChoix, dao);
		this.setSc(scan);
	}

	/**
	 * Effectue l'action li�e au choix
	 */
	public abstract Boolean faireUneAction();

	/**
	 * Retourne le numero du choix
	 * @return the numeroChoix 
	 */
	public int getNumeroChoix() {
		return numeroChoix;
	}

	/**
	 * Modifie le numero du choix
	 * @param numeroChoix the numeroChoix to set
	 */
	public void setNumeroChoix(Integer numeroChoix) {
		this.numeroChoix = numeroChoix;
	}

	/**
	 * R�cup�re le nom du choix
	 * @return the nomChoix
	 */
	public String getNomChoix() {
		return nomChoix;
	}

	/**
	 * Modifie le nom du choix
	 * @param nomChoix the nomChoix to set
	 */
	public void setNomChoix(String nomChoix) {
		this.nomChoix = nomChoix;
	}

	/**
	 * @return the itemDao
	 */
	public IItemDao<G, I> getItemDao() {
		return itemDao;
	}

	/**
	 * @param itemDao the itemDao to set
	 */
	public void setItemDao(IItemDao<G, I> itemDao) {
		this.itemDao = itemDao;
	}

	/**
	 * @return the sc
	 */
	public Scanner getSc() {
		return sc;
	}

	/**
	 * @param sc the sc to set
	 */
	public void setSc(Scanner sc) {
		this.sc = sc;
	}
}
