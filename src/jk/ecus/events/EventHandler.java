package jk.ecus.events;

/**
 * Interface to implement in any wanted handler.
 * 
 * @author JohnyK
 *
 * @param <T>		type of event to handle
 * @param <R>		return type of the handler method (must be the same as the return type specified by the event)
 */
public interface EventHandler<T extends Event<?,R>,R> {
	
	/**
	 * Method that will handle an event.
	 * 
	 * @param event	the event that was triggered 
	 * @return				the result of the execution of the handler
	 */
	R handle(T event);

}
