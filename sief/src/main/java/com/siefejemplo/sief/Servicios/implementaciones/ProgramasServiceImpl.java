package com.siefejemplo.sief.Servicios.implementaciones;

import com.siefejemplo.sief.Servicios.ProgramasServicio;
import com.siefejemplo.sief.dto.request.ProgramaRequest;
import com.siefejemplo.sief.dto.response.ProgramaResponse;
import com.siefejemplo.sief.modelos.Programas;
import com.siefejemplo.sief.repositorios.ProgramasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramasServiceImpl implements ProgramasServicio {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProgramasRepository programasRepository;


    @Override
    public ProgramaResponse agregarServicio(ProgramaRequest programaRequest) {

        Programas programas = modelMapper.map(programaRequest, Programas.class);

        programasRepository.save(programas);

        ProgramaResponse response = modelMapper.map(programas, ProgramaResponse.class);

        return response;
    }
}
