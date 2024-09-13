package biz.craftline.server.domain.service;

import biz.craftline.server.api.dto.LoginUserDTO;
import biz.craftline.server.api.dto.RegisterDTO;
import biz.craftline.server.domain.model.User;
import biz.craftline.server.domain.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface AuthenticationService {


    public User register(RegisterDTO input) ;

    public User authenticate(LoginUserDTO input);

    public List<User> allUsers() ;
}
