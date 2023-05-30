package com.siefejemplo.sief.Controlador;

import com.siefejemplo.sief.Servicios.UsuarioServicio;
import com.siefejemplo.sief.dto.LoginDTO;
import com.siefejemplo.sief.dto.request.UsuarioRegisterRequest;
import com.siefejemplo.sief.dto.response.UsuarioResponse;
import com.siefejemplo.sief.modelos.Rol;
import com.siefejemplo.sief.repositorios.RolRepository;
import com.siefejemplo.sief.repositorios.UserRepository;
import com.siefejemplo.sief.security.JWTAuthResponseDTO;
import com.siefejemplo.sief.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthControlador {

    @Autowired
    private UsuarioServicio usuarioService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository usuarioRepositorio;

    @Autowired
    private RolRepository rolRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/iniciarSesion")
    public ResponseEntity<JWTAuthResponseDTO> authenticateUser(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //obtenemos el token del jwtTokenProvider
        String token = jwtTokenProvider.generarToken(authentication);

        return ResponseEntity.ok(new JWTAuthResponseDTO(token));
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping(value = "/registro")
    public ResponseEntity<UsuarioResponse> registroPlataforma(@RequestBody UsuarioRegisterRequest usuarioRegisterRequest)
    {

        Rol role = new Rol();
        role.setId(1L);
        role.setNombre("ROLE_USER");

        return new ResponseEntity<>(usuarioService.registrarse(usuarioRegisterRequest, role), HttpStatus.CREATED);
    }

}
