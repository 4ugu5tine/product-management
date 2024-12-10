package org.edem.productmanagement.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.edem.productmanagement.dto.ResponseMessage;
import org.edem.productmanagement.dto.auth.LoginRequest;
import org.edem.productmanagement.dto.auth.SignUpRequest;
import org.edem.productmanagement.dto.auth.UserResponse;
import org.edem.productmanagement.entities.Roles;
import org.edem.productmanagement.entities.User;
import org.edem.productmanagement.exception.DuplicateEmailException;
import org.edem.productmanagement.exception.UserNotFoundException;
import org.edem.productmanagement.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.edem.productmanagement.utils.Validator.*;

@Service
@AllArgsConstructor
class UserServiceImpl implements UserService{

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    @Override
    public ResponseMessage createUser(SignUpRequest request) {

        Optional<User> byEmail = userRepository.findByEmail(request.email());
        if(byEmail.isPresent())
            throw new DuplicateEmailException(DUPLICATE_EMAIL);

        User user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Roles.USER)
                .build();
         userRepository.save(user);
         return  new ResponseMessage(USER_CREATED);
    }

    @Override
    public UserResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email()).orElseThrow(()-> new UserNotFoundException(INVALID_EMAIL_OR_PASSWORD));
        UserResponse response = UserResponse.builder()
                .name(user.getFirstName()+ " " + user.getLastName())
                .email(request.email())
                .role(user.getRole())
                .build();

        return response;
    }
}


