package biz.craftline.server.domain.repository;

import biz.craftline.server.domain.model.Role;
import biz.craftline.server.domain.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    @NotNull List<Role> findAll();

    void deleteRoleById(Long id);
}