package biz.craftline.server.domain.service;

import biz.craftline.server.domain.model.Role;
import biz.craftline.server.domain.model.User;
import biz.craftline.server.domain.repository.RoleRepository;
import biz.craftline.server.domain.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    //Logger logger = (Logger) LoggerFactory.getLogger(getClass().getName());

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //logger.info("==> loadUserByUsername: " + username);
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

