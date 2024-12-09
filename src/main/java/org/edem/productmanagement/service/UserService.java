package org.edem.productmanagement.service;

import org.edem.productmanagement.dto.CreateUserRequest;
import org.edem.productmanagement.entities.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User createUser (CreateUserRequest request);

}
