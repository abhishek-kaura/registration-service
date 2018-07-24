package com.shoppingcart.registration.helper;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.shoppingcart.registration.constants.RegistrationServiceConstants;
import com.shoppingcart.registration.dao.RegistrationRepository;
import com.shoppingcart.registration.entity.Usr;
import com.shoppingcart.registration.exception.RegisterServiceException;
import com.shoppingcart.registration.request.RegisterUserRequest;
import com.shoppingcart.registration.util.RegistrationUtil;

@Component
public class RegistrationServiceHelper {

	@Autowired
	private transient RegistrationRepository registrationRepository;

	public void registerUser(RegisterUserRequest registerUserRequest) throws RegisterServiceException,SQLServerException {
		
		Boolean isRequestValid = RegistrationUtil.isRequestValidForRegisterUser(registerUserRequest);
		Usr usr = null;

		if (isRequestValid) {
			
			usr = new Usr();

			usr.setUserName(StringUtils.trim(registerUserRequest.getUserName()));
			usr.setFirstName(StringUtils.upperCase(StringUtils.trim(registerUserRequest.getFirstName())));
			usr.setMiddleName(StringUtils.upperCase(StringUtils.trim(registerUserRequest.getMiddleName())));
			usr.setLastName(StringUtils.upperCase(StringUtils.trim(registerUserRequest.getLastName())));
			usr.setEmail(StringUtils.trim(registerUserRequest.getEmail()));
			usr.setGender(StringUtils.upperCase(StringUtils.trim(registerUserRequest.getGender())));
			usr.setDob(registerUserRequest.getDob());

			registrationRepository.save(usr);

		} else {
			throw new RegisterServiceException(RegistrationServiceConstants.ERR_CODE_4002,
					"Request is not valid for registering the user");
		}
		
	}

}
