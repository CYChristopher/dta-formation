/**
 * 31 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Ingredient;

/**
 * @author Christopher CHARLERY
 *
 */
public interface IIngredientRepository extends JpaRepository<Ingredient, Integer>{

}
