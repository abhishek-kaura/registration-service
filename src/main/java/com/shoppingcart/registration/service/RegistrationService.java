package com.shoppingcart.registration.service;

import com.shoppingcart.registration.exception.RegisterServiceException;
import com.shoppingcart.registration.request.RegisterUserRequest;
import com.shoppingcart.registration.response.BaseResponse;

public interface RegistrationService {
	
	BaseResponse registerUser(final RegisterUserRequest registerUserRequest) throws RegisterServiceException;

}
