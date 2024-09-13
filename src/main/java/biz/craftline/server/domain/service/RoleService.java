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
import java.util.Optional;

public interface RoleService {
    public List<Role> findAll() ;

    public Role addRole(String role);

    public void makeInactiveRole(Role role);

}

