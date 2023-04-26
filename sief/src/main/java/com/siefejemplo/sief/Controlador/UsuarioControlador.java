package com.siefejemplo.sief.Controlador;

import com.siefejemplo.sief.Servicios.implementaciones.UsuarioServiceImpl;
import com.siefejemplo.sief.modelos.Usuario;
import com.siefejemplo.sief.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class UsuarioControlador {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hola")
    public String holaMundo()
    {
        return "Hola mundo";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/adios")
    public String adios()
    {
        return "Adios usuario";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/guardar")
    public ResponseEntity<Usuario> registrarUsuarrio(@RequestBody Usuario usuario)
    {
        return new ResponseEntity<>(usuarioService.registarUsuario(usuario), HttpStatus.CREATED);
    }
}
