package biz.craftline.server.infrastructure.service;

import biz.craftline.server.api.dto.LoginUserDTO;
import biz.craftline.server.api.dto.RegisterDTO;
import biz.craftline.server.domain.model.User;
import biz.craftline.server.domain.repository.UserRepository;
import biz.craftline.server.domain.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    public User register(RegisterDTO input) {
        User user;
        try {
            user = new User()
                    .setFullName(input.getFullName())
                    .setEmail(input.getEmail())
                    .setPassword(passwordEncoder.encode(input.getPassword()));
        } catch (Exception e) {
            throw new AuthenticationServiceException(e.getMessage());
        }
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                input.getEmail(),
                input.getPassword()
            )
        );

        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }

    public List<User> allUsers() {
        return new ArrayList<>(userRepository.findAll());
    }
}
