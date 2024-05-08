package com.example.car_rental_spring.controller;

import com.example.car_rental_spring.dto.SignupRequest;
import com.example.car_rental_spring.dto.UserDto;
import com.example.car_rental_spring.entity.User;
import com.example.car_rental_spring.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {
        UserDto createdCustomerDto = authService.createCustomer(signupRequest);
        if(createdCustomerDto == null) return new ResponseEntity<>
            ("Customer ot created, Come again Later", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
    }
}
