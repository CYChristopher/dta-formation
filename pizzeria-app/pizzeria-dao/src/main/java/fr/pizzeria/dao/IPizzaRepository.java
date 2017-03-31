/**
 * 30 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
public interface IPizzaRepository extends JpaRepository<Pizza, Integer> {

	List<Pizza> findByCode(String code);
	
}
