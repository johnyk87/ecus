package jk.ecus.events;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jk.ecus.events.exception.EventsException;

/**
 * The event manager stores and manages all events and handlers, according to their types.
 * 
 * @author JohnyK
 *
 * @param <T>		type of the event this manager will handle
 * @param <R>		return type of the event handler methods
 */
public class EventManager<T extends Event<?,R>, R> {
	
    //--------------------------------------------------
	//singleton
	
	private static Map<Class<? extends Event<?,?>>, EventManager<? extends Event<?,?>,?>> instances;
	
	/**
	 * Singleton class that controls the access to each event manager.
	 * 
	 * @param <T>					the type of the event managed by the wanted event manager
	 * @param <R>					the return type of the event handler methods
	 * @param eventClass		class object that represents the type of the event
	 * @return							the event manager responsible for that type of event
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Event<?,R>,R> EventManager<T,R> getInstance(Class<T> eventClass)
	{
		if(instances == null)
			instances = new HashMap<Class<? extends Event<?,?>>, EventManager<? extends Event<?,?>,?>>();
		
		EventManager<T,R> instance = (EventManager<T,R>) instances.get(eventClass);
		
		if(instance == null)
		{
			instance = new EventManager<T,R>();
			instances.put(eventClass, instance);
		}
		
		return instance;
	}
	
    //--------------------------------------------------
	//members
	
	private List<EventHandler<T,R>> handlers;

	private EventManager()
	{
		handlers = new LinkedList<EventHandler<T,R>>();
	}
	
    //--------------------------------------------------
	//API
	
	/**
	 * Subscribe an event handler to this type of event.
	 * 
	 * @param handler					the handler to subscribe
	 * @throws EventsException	if the argument is null
	 */
	public void subscribe(EventHandler<T,R> handler) throws EventsException
	{
		if(handler == null)
			throw new EventsException("Null handler!");
		
		if(!handlers.contains(handler))
			handlers.add(handler);
	}
	
	/**
	 * Trigger an event and execute all subscribed handlers.
	 * 
	 * @param event	the event that will be passed as a parameter to all handlers
	 * @return				a list of all the results from the execution of the handlers
	 */
	public List<R> trigger(T event)
	{
		List<R> results = new LinkedList<R>();
		
		for(int i=0; i<handlers.size(); i++)
		{
			results.add(handlers.get(i).handle(event));
		}
		
		return results;
	}
}
