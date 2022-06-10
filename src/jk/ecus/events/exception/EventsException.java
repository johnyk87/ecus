package jk.ecus.events.exception;

import jk.ecus.exception.ECUException;

/**
 * Root of all events exceptions
 * 
 * @author JohnyK
 *
 */
public class EventsException extends ECUException {

	private static final long serialVersionUID = -3890617061723814707L;

	/**
     * 
     */
    public EventsException()
    {	
    }

    /**
     * @param message
     */
    public EventsException(String message)
    {
        super(message);
    }

    /**
     * @param cause
     */
    public EventsException(Throwable cause)
    {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public EventsException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
