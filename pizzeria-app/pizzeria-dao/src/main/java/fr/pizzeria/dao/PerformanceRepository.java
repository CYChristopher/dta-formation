/**
 * 30 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Performance;

/**
 * @author Christopher CHARLERY
 *
 */
public interface PerformanceRepository extends JpaRepository<Performance, Integer>{

}
