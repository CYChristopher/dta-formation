/**
 * 30 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.aspect;

import java.time.ZonedDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.PerformanceRepository;
import fr.pizzeria.model.Performance;

/**
 * @author Christopher CHARLERY
 *
 */
@Component
@Aspect
public class TechnicAspect {

	@Autowired
	private PerformanceRepository repository;
	
	@Pointcut("execution(* fr.pizzeria.controller.IngredientController.*(..))")
	private void method(){}
	
	@Around("method()")
	public Object afterMethod(ProceedingJoinPoint point) throws Throwable {
		long timeBefore = System.currentTimeMillis();
		Object result = point.proceed();
		Long timeAfter = System.currentTimeMillis();
		String nomMethod = point.toString();
		Performance performance = new Performance(nomMethod, ZonedDateTime.now(), timeAfter - timeBefore);
		repository.save(performance);
		return result;
	}
	
}
