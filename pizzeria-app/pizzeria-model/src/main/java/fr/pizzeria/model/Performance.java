/**
 * 30 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Christopher CHARLERY
 *
 */
@Entity
public class Performance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String service;
	@Column(nullable = false)
	private ZonedDateTime dateTime;
	@Column(nullable = false)
	private Long tempsExecution;
	
	/**
	 * 
	 */
	public Performance() {
		// Constructeur par defaut
	}

	/**
	 * @param service
	 * @param dateTime
	 * @param tempsExecution
	 */
	public Performance(String service, ZonedDateTime dateTime, Long tempsExecution) {
		super();
		this.service = service;
		this.dateTime = dateTime;
		this.tempsExecution = tempsExecution;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * @return the dateTime
	 */
	public ZonedDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(ZonedDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the tempsExecution
	 */
	public Long getTempsExecution() {
		return tempsExecution;
	}

	/**
	 * @param tempsExecution the tempsExecution to set
	 */
	public void setTempsExecution(Long tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
}
