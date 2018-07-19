package com.shoppingcart.registration.exception;


/**
 * The Class MetricsMart Service Exception.
 * 
 * @author Abhishek Kaura(M082447)
 * @version V1.0
 */
public class RegisterServiceException extends Exception{
	
	/**
	 * add serial version
	 */
	private static final long serialVersionUID = 1L;
	private transient String errorCode;
	private transient String errorMessage;

	/**
	 * Instantiates a new Metrics Mart service exception.
	 * 
	 * @param cause
	 */
	public RegisterServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new Metrics Mart service exception.
	 *
	 * @param errorCode
	 *            the error code
	 * @param errorMessage
	 *            the error message
	 * @param cause
	 *            the cause
	 */
	public RegisterServiceException(String errorCode, String errorMessage, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * Instantiates a new Metrics Mart service exception.
	 *
	 * @param errorCode
	 *            the error code
	 * @param errorMessage
	 *            the error message
	 */
	public RegisterServiceException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
