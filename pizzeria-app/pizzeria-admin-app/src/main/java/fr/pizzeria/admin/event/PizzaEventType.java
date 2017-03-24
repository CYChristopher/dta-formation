/**
 * 23 mars 2017 Christopher CHARLERY
 */
package fr.pizzeria.admin.event;

/**
 * @author Christopher CHARLERY
 *
 */
public enum PizzaEventType {
	SAVE ("Save"), UPDATE ("Update"), DELETE ("Delete");
	
	private String eventType;
		
		/**
		 * 
		 */
		private PizzaEventType(String type) {
			this.eventType = type;
		}

		/**
		 * @return the eventType
		 */
		public String getEventType() {
			return eventType;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return eventType;
		}
}
