package jk.ecus.properties.exception;

import jk.ecus.exception.ECUException;

/**
 * Root of all properties exceptions.
 * 
 * @author JohnyK
 *
 */
public class PropertiesException extends ECUException {

	private static final long serialVersionUID = -1490030896098563672L;

	/**
	 * 
	 */
	public PropertiesException()
	{
	}

	/**
	 * @param message
	 */
	public PropertiesException(String message)
	{
		super(message);
	}

	/**
	 * @param cause
	 */
	public PropertiesException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PropertiesException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
