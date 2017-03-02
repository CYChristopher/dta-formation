/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

import dta.chat.controller.ChatAuthController;
import dta.chat.controller.ChatConvController;
import dta.chat.model.ChatConversationModel;

/**
 * @author Christopher CHARLERY
 *	Interface Composite
 */
public abstract class ViewComposite{

	private List<ViewComposite> children = new ArrayList<>();
	protected ChatAuthController authController;
	protected ChatConvController convController;
	protected ChatConversationModel model;

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
		this.authController = controller;
		this.children.forEach(composite -> composite.authController = controller);
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
		this.children.forEach(composite -> composite.login = login);
	}

	/**
	 * @param convController the convController to set
	 */
	public void setConvController(ChatConvController convController) {
		this.convController = convController;
		this.children.forEach(composite -> composite.convController = convController);
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(ChatConversationModel model) {
		this.model = model;
		this.children.forEach(composite -> composite.model = model);
	}
	
}
