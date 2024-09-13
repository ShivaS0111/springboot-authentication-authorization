package biz.craftline.server.infrastructure.service;

import biz.craftline.server.domain.model.Role;
import biz.craftline.server.domain.model.User;
import biz.craftline.server.domain.repository.RoleRepository;
import biz.craftline.server.domain.repository.UserRepository;
import biz.craftline.server.domain.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void assignRoleToUser(Long userId, Long roleId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new Exception("Role not found"));
        user.addRole(role);
        userRepository.save(user);
    }

    public void deleteRoleToUser(Long userId, Long roleId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new Exception("Role not found"));
        user.deleteRole(role);
        userRepository.save(user);
    }

    public List<User> allUsers() {
        return userRepository.findAll().stream().toList();
    }

}

