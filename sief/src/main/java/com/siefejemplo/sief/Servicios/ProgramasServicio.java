package com.siefejemplo.sief.Servicios;

import com.siefejemplo.sief.dto.request.ProgramaRequest;
import com.siefejemplo.sief.dto.response.ProgramaResponse;
import com.siefejemplo.sief.modelos.Programas;

public interface ProgramasServicio {


    public ProgramaResponse agregarServicio(ProgramaRequest programaRequest);

}
