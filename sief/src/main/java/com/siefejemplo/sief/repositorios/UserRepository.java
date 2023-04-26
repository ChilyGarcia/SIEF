package com.siefejemplo.sief.repositorios;

import com.siefejemplo.sief.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.OptionalInt;

public interface UserRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByEmail(String email);
    public Optional<Usuario> findByUsernameOrEmail(String username, String email);
    public Optional<Usuario> findByUsername(String username);
    public Boolean existsByUsername(String username);
    public Boolean existsByEmail(String email);
}
