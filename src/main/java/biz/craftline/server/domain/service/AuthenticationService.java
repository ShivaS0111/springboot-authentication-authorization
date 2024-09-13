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

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public AuthenticationService(
        UserRepository userRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

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
