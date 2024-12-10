package org.edem.productmanagement.service;

import org.edem.productmanagement.dto.ResponseMessage;
import org.edem.productmanagement.dto.auth.LoginRequest;
import org.edem.productmanagement.dto.auth.SignUpRequest;
import org.edem.productmanagement.dto.auth.UserResponse;

public interface UserService {
    ResponseMessage createUser (SignUpRequest request);

    UserResponse login (LoginRequest request);

}
