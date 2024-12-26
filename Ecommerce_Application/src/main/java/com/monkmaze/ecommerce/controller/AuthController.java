package com.monkmaze.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monkmaze.ecommerce.entity.LoginRequest;
import com.monkmaze.ecommerce.entity.RefreshRequest;
import com.monkmaze.ecommerce.entity.User;
import com.monkmaze.ecommerce.repository.UserRepository;
import com.monkmaze.ecommerce.utils.JwtUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Authentication", description = "API endpoints for user authentication")
public class AuthController {

    @Autowired
    private JwtUtils jwtUtils;
 
     private LoginRequest loginRequest;
     
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    @Operation(
        summary = "Register a new user",
        description = "Allows a new user to sign up by providing user details."
    )
    public ResponseEntity<?> signup(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok("User Registered Successfully");
    }

    @PostMapping("/signin")
    @Operation(
        summary = "Authenticate user and generate tokens",
        description = "Validates the user's email and password and generates an access token and refresh token."
    )
    public ResponseEntity<?> signin(@RequestBody LoginRequest loginrequest) {
       
        String accessToken = jwtUtils.generateJwtToken(loginrequest.getEmail());
        String refreshToken = jwtUtils.generateRefreshToken(loginrequest.getEmail());
        return ResponseEntity.ok("accesstoken :" + accessToken + ", refreshtoken :" + refreshToken);
    }

    @PostMapping("/refresh")
    @Operation(
        summary = "Generate a new access token using refresh token",
        description = "Allows the user to obtain a new access token using a valid refresh token."
    )
    public ResponseEntity<?> refresh(@RequestBody RefreshRequest refreshRequest) {
       
        String username = jwtUtils.getUsername(refreshRequest.getRefreshToken());
        String newToken = jwtUtils.generateJwtToken(username);
        return ResponseEntity.ok("access_token :" + newToken);
    }
}
