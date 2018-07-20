package com.shoppingcart.registration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.registration.exception.RegisterBusinessError;
import com.shoppingcart.registration.exception.RegisterServiceException;
import com.shoppingcart.registration.request.RegisterUserRequest;
import com.shoppingcart.registration.response.BaseResponse;
import com.shoppingcart.registration.service.RegistrationService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	private transient RegistrationService registrationService;
	
	/**
	 * Say welcome message to Registration  API.
	 *
	 * @return the response entity
	 */
	@ApiOperation(value = "Welcome Message for the Registration API", 
			notes = "This method will be used to welcome the user to Registration API")
	@GetMapping(value = "/welcome")
	@CrossOrigin
	public ResponseEntity<String> sayWelcomeMessageToRegistrationAPI() {

		return new ResponseEntity<String>("Welcome to Registration API", getHeaders(), HttpStatus.OK);

	}
	
	@ApiOperation(value="Register User",notes="This method will be used to register the user")
	@PostMapping(value="/registerUser")
	@CrossOrigin
	public ResponseEntity<BaseResponse> registerUser(RegisterUserRequest registerUserRequest) throws RegisterServiceException{
		
		logger.info(RegistrationController.class.getName(),"Enter --> registerUser()");
		
		BaseResponse registerUserResponse = null;
		registerUserResponse =  registrationService.registerUser(registerUserRequest);
		
		logger.info(RegistrationController.class.getName(),"Exit --> registerUser()");
		
		return new ResponseEntity<BaseResponse>(registerUserResponse, getHeaders(), HttpStatus.OK);
		
	}
	
	
	@ExceptionHandler(RegisterServiceException.class)
	public ResponseEntity<RegisterBusinessError> handleBusinessException(
			final RegisterServiceException serviceException) {

		logger.info(RegistrationController.class.getName(), "Enter --> handleBusinessException ()");

		RegisterBusinessError registerBusinesssError = new RegisterBusinessError();

		registerBusinesssError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		registerBusinesssError.setErrorCode(serviceException.getErrorCode());
		registerBusinesssError.setMessage(serviceException.getErrorMessage());

		logger.info(RegistrationController.class.getName(), "Exit --> handleBusinessException()");

		return new ResponseEntity<RegisterBusinessError>(registerBusinesssError,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
