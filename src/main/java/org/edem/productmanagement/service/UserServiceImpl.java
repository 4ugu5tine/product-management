package org.edem.productmanagement.service;

import lombok.RequiredArgsConstructor;
import org.edem.productmanagement.dto.CreateUserRequest;
import org.edem.productmanagement.entities.User;
import org.edem.productmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Override
    public User createUser(CreateUserRequest request) {

        User user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .build();
        return userRepository.save(user);
    }
}
