package com.shoppingcart.registration.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shoppingcart.registration.request.RegisterUserRequest;
import com.shoppingcart.registration.response.BaseResponse;

public final class RegistrationUtil {

	private static final Logger logger = LoggerFactory.getLogger(RegistrationUtil.class);

	private RegistrationUtil() {
		// Default Constructor
	}

	public static Boolean isRequestValidForRegisterUser(RegisterUserRequest registerUserRequest) {

		logger.info(RegistrationUtil.class.getName(),"Enter --> isRequestValidForRegisterUser()");
		
		Boolean isRequestValid = Boolean.TRUE;

		if (registerUserRequest == null) {
			isRequestValid = Boolean.FALSE;
		} else if (StringUtils.isBlank(registerUserRequest.getFirstName())) {
			isRequestValid = Boolean.FALSE;
		} else if (StringUtils.isBlank(registerUserRequest.getLastName())) {
			isRequestValid = Boolean.FALSE;
		} else if (StringUtils.isBlank(registerUserRequest.getUserName())) {
			isRequestValid = Boolean.FALSE;
		} else if (StringUtils.isBlank(registerUserRequest.getEmail())) {
			isRequestValid = Boolean.FALSE;
		}else if (StringUtils.isBlank(registerUserRequest.getGender())) {
			isRequestValid = Boolean.FALSE;
		}else if(registerUserRequest.getDob() == null) {
			isRequestValid = Boolean.FALSE;
		}else {
			isRequestValid = Boolean.TRUE;
		}
		
		logger.info(RegistrationUtil.class.getName(),"Exit --> isRequestValidForRegisterUser()");

		return isRequestValid;

	}

	public static void transformBaseResponse(BaseResponse registrationResponse) {
		

		logger.info(RegistrationUtil.class.getName(), "Enter --> transformBaseResponse()");

		registrationResponse.setStatus(true);
		registrationResponse.setStatuscode("SUCCESS");
		registrationResponse.setErrorOccured(false);
		registrationResponse.setErrorDesc("No Error");

		logger.info(RegistrationUtil.class.getName(), "Exit --> transformBaseResponse()");
		
	}

}
