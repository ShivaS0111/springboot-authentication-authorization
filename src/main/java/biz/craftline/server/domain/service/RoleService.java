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

@Service
public class RoleService {
    private final RoleRepository repository;

    public RoleService(RoleRepository roleRepository) {
        this.repository = roleRepository;
    }

    public List<Role> findAll() {
        return repository.findAll();
    }

    public Role addRole(String role) {
        Role roleEntity = new Role().setName(role);
        return repository.save(roleEntity);
    }

    public void makeInactiveRole(Role role) {
        role.setStatus(2);
        repository.save(role);
    }

}

