package biz.craftline.server.api.controller;

import biz.craftline.server.api.dto.RegisterDTO;
import biz.craftline.server.api.response.APIResponse;
import biz.craftline.server.api.response.LoginResponse;
import biz.craftline.server.domain.service.AuthenticationService;
import biz.craftline.server.domain.service.JWTService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.craftline.server.api.dto.LoginUserDTO;
import biz.craftline.server.domain.model.User;

import java.util.logging.Logger;

import static biz.craftline.server.utils.network.NetworkUtilsKt.success;


@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JWTService jwtService;
    private final AuthenticationService authenticationService;

    //private Logger logger = (Logger) LoggerFactory.getLogger(getClass().getName());

    public AuthenticationController(JWTService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<APIResponse<User>> register(@RequestBody RegisterDTO registerUserDto) {
        //logger.info("==> register, input:" + registerUserDto);
        User registeredUser = authenticationService.register(registerUserDto);
        return success(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse<LoginResponse>> authenticate(@RequestBody LoginUserDTO loginUserDto) {
        //logger.info("==> login, input:" + loginUserDto);
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());
        return success(loginResponse);
    }
}