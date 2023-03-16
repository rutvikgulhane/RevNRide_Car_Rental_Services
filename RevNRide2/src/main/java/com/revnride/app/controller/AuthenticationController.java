package com.revnride.app.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revnride.app.dto.request.LoginRequest;
import com.revnride.app.dto.request.UserRequest;
import com.revnride.app.dto.response.JwtResponse;
import com.revnride.app.dto.response.LocalizationResponse;
import com.revnride.app.exception.WrongDataException;
import com.revnride.app.security.JwtUtils;
import com.revnride.app.service.CarService;
import com.revnride.app.service.LocalizationService;
import com.revnride.app.service.RoleService;
import com.revnride.app.service.UserService;
//import com.revnride.app.service.impl.SendMailImpl;
import com.revnride.app.service.impl.UserDetailsimpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthenticationController {


    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
 
    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    private final UserService userServiceImpl;

    private final LocalizationService localizationServiceImpl;
 
    private final RoleService roleServiceImpl;
 
    private final PasswordEncoder encoder;

    private final CarService carServiceImpl;
 

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, 
    		JwtUtils jwtUtils, UserService userServiceImpl, LocalizationService localizationServiceImpl, 
			RoleService roleServiceImpl, PasswordEncoder encoder,
			CarService carServiceImpl/* , SendMailImpl sendMailImpl */) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userServiceImpl = userServiceImpl;
        this.localizationServiceImpl = localizationServiceImpl;
        this.roleServiceImpl = roleServiceImpl;
        this.encoder = encoder;
        this.carServiceImpl = carServiceImpl;
//        this.sendMailImpl = sendMailImpl;
    }


    @ResponseBody
    @PostMapping("/authentication")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsimpl userDetails = (UserDetailsimpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        List<LocalizationResponse> localizations = localizationServiceImpl.findAll();

        logger.info("------>>> user:" + loginRequest.getUsername());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                localizations,
                roles));
    }

    @ResponseBody
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest) {
        logger.info("------ User successfully registered------");
//        System.out.println("--- in user registerUser(), AuthCont --> " + userRequest);
        userServiceImpl.save(userRequest);
        return new ResponseEntity<>(userRequest, HttpStatus.OK);
    }
}
