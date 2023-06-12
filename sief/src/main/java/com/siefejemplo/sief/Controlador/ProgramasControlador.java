package com.siefejemplo.sief.Controlador;

import com.siefejemplo.sief.Servicios.implementaciones.ProgramasServiceImpl;
import com.siefejemplo.sief.dto.request.ProgramaRequest;
import com.siefejemplo.sief.dto.response.ProgramaResponse;
import com.siefejemplo.sief.repositorios.ProgramasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("programas")
public class ProgramasControlador {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProgramasServiceImpl programasService;

    @Autowired
    private ProgramasRepository programasRepository;


    @CrossOrigin(origins = "http://localhost:8081")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/guardarPrograma")
    public ResponseEntity<ProgramaResponse> guardarPrograma(@RequestBody ProgramaRequest programaRequest)
    {

        return new ResponseEntity<>(programasService.agregarServicio(programaRequest), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listaProgramas")
    public ResponseEntity<?> listaTotalProgramas ()
    {
        return new ResponseEntity<>(programasService.listaDeProgramas(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listaProgramaPorCodigo/{codigo}")
    public ResponseEntity<?> listaProgramaCodigo(@PathVariable("codigo")String codigo){
        return new ResponseEntity<>(programasService.listaProgramasCodigo(codigo), HttpStatus.OK);
    }


}
