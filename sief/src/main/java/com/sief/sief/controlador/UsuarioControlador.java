package com.sief.sief.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contactos")
public class UsuarioControlador {

    @GetMapping
    public String holaMundo()
    {
        return "Hola mundo";
    }
}
