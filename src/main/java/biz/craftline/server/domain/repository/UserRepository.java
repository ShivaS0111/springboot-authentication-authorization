package biz.craftline.server.domain.repository;

import java.util.List;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;

import biz.craftline.server.domain.model.User;


public interface UserRepository {
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);

    @NotNull List<User> findAll();

    User save(User user);
}