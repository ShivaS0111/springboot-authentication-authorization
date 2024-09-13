package biz.craftline.server.infrastructure.persistence;

import biz.craftline.server.domain.model.Role;
import biz.craftline.server.domain.repository.RoleRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleJpaRepository extends JpaRepository<Role, Long>, RoleRepository {


    @NotNull List<Role> findAll();

    void deleteRoleById(Long id);
}
