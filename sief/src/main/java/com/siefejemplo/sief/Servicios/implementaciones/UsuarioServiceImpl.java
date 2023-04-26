package com.siefejemplo.sief.Servicios.implementaciones;

import com.siefejemplo.sief.Servicios.UsuarioServicio;
import com.siefejemplo.sief.modelos.Usuario;
import com.siefejemplo.sief.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioServicio {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Usuario registarUsuario(Usuario usuario) {
        Usuario usuarioGuardar = userRepository.save(usuario);

        return usuarioGuardar;
    }
}
