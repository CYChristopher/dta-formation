/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

import dta.chat.controller.ChatAuthController;

/**
 * @author Christopher CHARLERY
 *	Interface Composite
 */
public abstract class ViewComposite{

	private List<ViewComposite> children = new ArrayList<>();
	protected ChatAuthController controller;
	protected String login;

	public void add(ViewComposite view) {
		this.children.add(view);
	}

	public int count() {
		return this.children.size();
	}

	//protected abstract void printThisBefore();

	//protected abstract void printThisAfter();

	/**
	 * Print
	 */
	public void print() {
		//printThisBefore();
		for (ViewComposite letter : this.children) {
			letter.print();
		}
		//printThisAfter();
	}
	
	/**
	 * 
	 * @param controller
	 */
	public void setAuthController(ChatAuthController controller){
		this.controller = controller;
		this.children.forEach(composite -> composite.controller = controller);
	}

	/**
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
		this.children.forEach(composite -> composite.login = login);
	}

}
