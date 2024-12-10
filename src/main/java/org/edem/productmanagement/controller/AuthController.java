package org.edem.productmanagement.controller;


import lombok.AllArgsConstructor;
import org.edem.productmanagement.dto.ResponseMessage;
import org.edem.productmanagement.dto.auth.LoginRequest;
import org.edem.productmanagement.dto.auth.SignUpRequest;
import org.edem.productmanagement.dto.auth.UserResponse;
import org.edem.productmanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public ResponseMessage signup(@Valid @RequestBody SignUpRequest request){
         return userService.createUser(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public UserResponse login(@RequestBody LoginRequest request){
        return userService.login(request);
    }



}
