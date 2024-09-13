package biz.craftline.server.infrastructure.service;

import biz.craftline.server.domain.model.Role;
import biz.craftline.server.domain.repository.RoleRepository;
import biz.craftline.server.domain.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository repository;

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

