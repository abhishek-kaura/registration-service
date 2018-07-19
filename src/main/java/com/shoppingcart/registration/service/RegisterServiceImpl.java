package com.shoppingcart.registration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import com.shoppingcart.registration.constants.RegistrationServiceConstants;
import com.shoppingcart.registration.exception.RegisterServiceException;
import com.shoppingcart.registration.helper.RegistrationServiceHelper;
import com.shoppingcart.registration.request.RegisterUserRequest;
import com.shoppingcart.registration.response.BaseResponse;
import com.shoppingcart.registration.util.RegistrationUtil;


@Service
public class RegisterServiceImpl implements RegistrationService{
	

	private static final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);
	
	@Autowired
	private transient RegistrationServiceHelper registrationServiceHelper;
	
	@Override
	public BaseResponse registerUser(RegisterUserRequest registerUserRequest) throws RegisterServiceException {
		
		logger.info(RegisterServiceImpl.class.getName(),"Enter --> registerUser()");
		
		BaseResponse registrationResponse = new BaseResponse();
		
		try {
			registrationServiceHelper.registerUser(registerUserRequest);
		}catch (DataIntegrityViolationException ex) {
			logger.error(RegistrationServiceConstants.ERR_CODE_4001, ex);
			throw new RegisterServiceException(RegistrationServiceConstants.ERR_CODE_4001,
					"Error Occurred while inserting the user in the database", ex);
		} catch (SQLServerException ex) {
			logger.error(RegistrationServiceConstants.ERR_CODE_4001, ex);
			throw new RegisterServiceException(RegistrationServiceConstants.ERR_CODE_4001,
					"Error Occurred while inserting the user in the database", ex);
		}
		
		
		RegistrationUtil.transformBaseResponse(registrationResponse);
		
		logger.info(RegisterServiceImpl.class.getName(),"Exit --> registerUser()");
		
		return registrationResponse;
	}

}
