package jk.ecus.events;

/**
 * Root class for all events. 
 * 
 * @author JohnyK
 *
 * @param <T>		type of parameters it can hold 
 * @param <R>		type of any expected result of the handler methods
 */
public class Event<T,R> {
	
	private T details;

	/**
	 * Constructor that takes a parameter with event details.
	 * 
	 * @param details		details of the event or any parameters needed by the handlers
	 */
	public Event(T details)
	{
		this.details = details;
	}
	
	/**
	 * Getter to access the event's details.
	 * 
	 * @return		the details of the event
	 */
	public T getDetails()
	{
		return details;
	}
}
