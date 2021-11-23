package com.hendisantika.api.controller;

import com.hendisantika.dto.AuthenticationResponse;
import com.hendisantika.dto.CredentialsDto;
import com.hendisantika.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ecommerce-rest-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/21
 * Time: 08.35
 */
@RestController
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private SecurityService securityService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        final String username = credentialsDto.getUsername();
        final String password = credentialsDto.getPassword();

        // Authenticating...
        final String token = securityService.authenticate(username, password);

        logger.debug("User '{}' authenticated successfully -> Token: '{}'", username, token);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
}
