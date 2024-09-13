package biz.craftline.server.infrastructure.persistence;

import biz.craftline.server.domain.model.User;
import biz.craftline.server.domain.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long>, UserRepository {

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long userId);

    @NotNull List<User> findAll();
}
