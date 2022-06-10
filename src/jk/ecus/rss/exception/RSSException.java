package jk.ecus.rss.exception;

import jk.ecus.exception.ECUException;

/**
 * Root of all rss exceptions
 * 
 * @author JohnyK
 *
 */
public class RSSException extends ECUException {

	private static final long serialVersionUID = 2742349471310351857L;

	/**
	 * 
	 */
	public RSSException()
	{
	}

	/**
	 * @param message
	 */
	public RSSException(String message)
	{
		super(message);
	}

	/**
	 * @param cause
	 */
	public RSSException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RSSException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
