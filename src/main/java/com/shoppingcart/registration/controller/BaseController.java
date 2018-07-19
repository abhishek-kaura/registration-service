package com.shoppingcart.registration.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpHeaders;


/**
 * The Class BaseController.
 * 
 * @author Abhishek Kaura
 * @version v1.0
 */
@CrossOrigin
public class BaseController {

	/**
	 * Gets the headers.
	 *
	 * @return the headers
	 */
	public HttpHeaders getHeaders() {

		HttpHeaders headers = new HttpHeaders();

		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		headers.add("Access-Control-Allow-Credentials", "true");
		headers.add("Access-Control-Max-Age", "3600");
		headers.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

		return headers;
	}
}
