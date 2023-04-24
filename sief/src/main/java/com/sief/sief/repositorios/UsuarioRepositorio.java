package com.sief.sief.repositorios;

import com.sief.sief.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findOneByEmail(String email);
}
