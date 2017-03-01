/**
 * 1 mars 2017 Christopher CHARLERY
 */
package dta.chat.model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christopher CHARLERY
 *
 */
public abstract class ChatObservable<T> {

	private List<ChatObserver<T>> observers;
	
	/**
	 * 
	 */
	public ChatObservable() {
		this.observers = new ArrayList<ChatObserver<T>>();
	}
	
	public void addObserver(ChatObserver<T> observer){
		this.observers.add(observer);
	}
	
	public void removeObserver(ChatObserver<T> observer){
		this.observers.remove(observer);
	}
	
	public void notifyObservers(T message){
		this.observers.forEach(o -> o.update(this, message));
	}
	
}
