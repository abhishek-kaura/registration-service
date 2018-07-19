package com.shoppingcart.registration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class BaseResponse.
 * 
 * @author Abhishek Kaura(M082447)
 * @version v1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {
	
	/** The statuscode. */
	private String statuscode;

	/** The status. */
	private Boolean status = false;

	/** The error desc. */
	private String errorDesc;

	/** The error occured. */
	private Boolean errorOccured = false;
	
	/**
	 * Instantiates a new base response.
	 */
	public BaseResponse() {
		// Default constructor
	}

	/**
	 * @return the statuscode
	 */
	public String getStatuscode() {
		return statuscode;
	}

	/**
	 * @param statuscode
	 *            the statuscode to set
	 */
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @return the errorDesc
	 */
	public String getErrorDesc() {
		return errorDesc;
	}

	/**
	 * @param errorDesc
	 *            the errorDesc to set
	 */
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	/**
	 * @return the errorOccured
	 */
	public Boolean getErrorOccured() {
		return errorOccured;
	}

	/**
	 * @param errorOccured
	 *            the errorOccured to set
	 */
	public void setErrorOccured(Boolean errorOccured) {
		this.errorOccured = errorOccured;
	}

}
