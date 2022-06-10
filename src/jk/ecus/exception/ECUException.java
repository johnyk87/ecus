package jk.ecus.exception;

/**
 * Root of all exceptions thrown by the ECUS
 * 
 * @author JohnyK
 *
 */
public class ECUException extends Exception {

	private static final long serialVersionUID = -9110508291582514806L;

	/**
	 * 
	 */
	public ECUException()
	{
	}

	/**
	 * @param message
	 */
	public ECUException(String message)
	{
		super(message);
	}

	/**
	 * @param cause
	 */
	public ECUException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ECUException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
