package jk.ecus.cache.exception;

import jk.ecus.exception.ECUException;

/**
 * Root of all cache exceptions.
 * 
 * @author JohnyK
 *
 */
public class CacheException extends ECUException {

	private static final long serialVersionUID = -781064186912537449L;

	/**
	 * 
	 */
	public CacheException()
	{
	}

	/**
	 * @param message
	 */
	public CacheException(String message)
	{
		super(message);
	}

	/**
	 * @param cause
	 */
	public CacheException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CacheException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
