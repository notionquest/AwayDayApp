package com.deloitte.awayday.exception;

/**
 * Away Day app exception
 * 
 * @author Sampath
 *
 */
public class AwayDayException extends Exception {

	private static final long serialVersionUID = 8062649343608667178L;

	String errorMessage;
	String errorCode;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public AwayDayException() {
		super();
	}

	public AwayDayException(String message, Throwable cause) {
		super(message, cause);
		this.errorMessage = message;
	}

	public AwayDayException(String message) {
		super(message);
		this.errorMessage = message;
	}

	public AwayDayException(String message, String errorCode) {
		super(message);
		this.errorMessage = message;
		this.errorCode = errorCode;
	}

	public AwayDayException(String message, String errorCode, Throwable cause) {
		super(message, cause);
		this.errorMessage = message;
		this.errorCode = errorCode;
	}

	public AwayDayException(Throwable cause) {
		super(cause);
	}

}
