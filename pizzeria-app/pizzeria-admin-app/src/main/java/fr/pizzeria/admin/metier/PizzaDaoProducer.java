/**
 * 23 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.admin.metier;

/**
 * @author Christopher CHARLERY
 *
 */

public interface PizzaDaoProducer {

	/*@Produces
	@ApplicationScoped
	public ItemDao<String, Pizza> pizzaDao() {
		ItemDao<String, Pizza> instanceDaoImpl = null;
		try{
			
			ResourceBundle bundle = ResourceBundle.getBundle("application");
			String daoImpl = bundle.getString("service.impl");
			instanceDaoImpl = (ItemDao<String, Pizza>) Class.forName(daoImpl).newInstance();
		} catch(InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			Logger.getLogger(PizzaDaoProducer.class.getName()).log(Level.WARNING, e.getMessage(), e);
		}
		return instanceDaoImpl;
	}*/
}
