package jk.ecus.files.exception;

import jk.ecus.exception.ECUException;

/**
 * Root of all file exceptions
 * 
 * @author JohnyK
 *
 */
public class FilesException extends ECUException {

	private static final long serialVersionUID = 5886183818918641609L;

	/**
	 * 
	 */
	public FilesException()
	{
	}

	/**
	 * @param message
	 */
	public FilesException(String message)
	{
		super(message);
	}

	/**
	 * @param cause
	 */
	public FilesException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FilesException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
