package biz.craftline.server.domain.service;

import biz.craftline.server.domain.model.Role;
import biz.craftline.server.domain.model.User;
import biz.craftline.server.domain.repository.RoleRepository;
import biz.craftline.server.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException ;

    public void assignRoleToUser(Long userId, Long roleId) throws Exception ;

    public void deleteRoleToUser(Long userId, Long roleId) throws Exception ;

    public List<User> allUsers();

}

