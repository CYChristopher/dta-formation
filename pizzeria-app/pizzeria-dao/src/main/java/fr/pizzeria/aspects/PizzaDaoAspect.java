/**
 * 30 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Pizza;

/**
 * @author Christopher CHARLERY
 *
 */
@Component
@Aspect
public class PizzaDaoAspect {

	@Pointcut("execution(* saveNewItem(..))")
	private void savePizza(){}
	
	@Pointcut("execution(* updateItem(..))")
	private void updatePizza(){}

	@Before("savePizza() && args(pizza)")
	public void beforeSave(Pizza pizza) {
		if(pizza.getCode() == null || pizza.getCode().trim().isEmpty()){
			String code = pizza.getNom().trim().substring(0, 3).toUpperCase();
			pizza.setCode(code);
		}
	}
	
	@Before("updatePizza() && args(code, pizza)")
	public void beforeSave(String code, Pizza pizza) {
		if(pizza.getCode() == null || pizza.getCode().trim().isEmpty()){
			String newCode = pizza.getNom().trim().substring(0, 3).toUpperCase();
			pizza.setCode(newCode);
		}
	}

}
