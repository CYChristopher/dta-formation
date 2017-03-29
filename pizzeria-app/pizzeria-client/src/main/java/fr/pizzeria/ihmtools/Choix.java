/**
 * 22 février. 2017 Christopher CHARLERY
 */
package fr.pizzeria.ihmtools;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.ItemDao;

/**
 * @author Christopher CHARLERY
 * @param <I> 
 * @param <G>
 *
 */
@Controller
public abstract class Choix<I, G> {
	
	private Integer numeroChoix;
	private String nomChoix;
	@Autowired
	private ItemDao<I, G> itemDao;
	@Autowired
	private Scanner sc;
	
	/**
	 * Crée un nouvel item d'un menu
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
	public Choix(Integer numeroChoix, String nomChoix, ItemDao<I, G> dao) {
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
	public Choix(Integer numeroChoix, String nomChoix, ItemDao<I, G> dao, Scanner scan) {
		this(numeroChoix, nomChoix, dao);
		this.setSc(scan);
	}

	/**
	 * Effectue l'action liée  au choix
	 * @return S'il faut continuer après l'execution de l'action liée à ce choix
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
	 * Récupere le nom du choix
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
	public ItemDao<I, G> getItemDao() {
		return itemDao;
	}

	/**
	 * @param itemDao the itemDao to set
	 */
	public void setItemDao(ItemDao<I, G> itemDao) {
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
