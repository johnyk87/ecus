package jk.ecus.sorter.exception;

import jk.ecus.exception.ECUException;

/**
 * Root of all rss exceptions
 * 
 * @author JohnyK
 *
 */
public class SorterException extends ECUException {

	private static final long serialVersionUID = 2742349471310351857L;

	/**
	 * 
	 */
	public SorterException()
	{
	}

	/**
	 * @param message
	 */
	public SorterException(String message)
	{
		super(message);
	}

	/**
	 * @param cause
	 */
	public SorterException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SorterException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
