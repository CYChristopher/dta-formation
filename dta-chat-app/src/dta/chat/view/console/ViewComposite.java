/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christopher CHARLERY
 *	Interface Composite
 */
public abstract class ViewComposite {

	private List<ViewComposite> children = new ArrayList<>();

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

}
