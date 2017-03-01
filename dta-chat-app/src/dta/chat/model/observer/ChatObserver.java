/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.model.observer;

/**
 * @author Christopher CHARLERY
 *
 */
public interface ChatObserver<T> {

	void update(ChatObservable<T> obersvable, T obj);
	
}
