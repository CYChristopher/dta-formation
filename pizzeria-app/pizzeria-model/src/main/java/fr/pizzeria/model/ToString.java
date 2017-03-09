/**
 * 24 février. 2017 Christopher CHARLERY
 */
package fr.pizzeria.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Christopher CHARLERY
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ToString {

	/**
	 * 
	 * @return
	 */
	boolean uppercase() default false;
	
}
