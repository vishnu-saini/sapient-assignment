package com.sapient.incomefinder.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class IncomeFinderApplicationException.
 */
public class IncomeFinderApplicationException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -761982813124377039L;

	/**
	 * Instantiates a new income finder application exception.
	 */
	public IncomeFinderApplicationException() {
		super(
				"There is some issue in our webservice, please reach out to our support team");
	}

	/**
	 * Instantiates a new income finder application exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public IncomeFinderApplicationException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instantiates a new income finder application exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public IncomeFinderApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new income finder application exception.
	 *
	 * @param message the message
	 */
	public IncomeFinderApplicationException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new income finder application exception.
	 *
	 * @param cause the cause
	 */
	public IncomeFinderApplicationException(Throwable cause) {
		super(cause);
	}

}