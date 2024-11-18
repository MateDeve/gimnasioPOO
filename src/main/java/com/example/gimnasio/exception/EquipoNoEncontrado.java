package com.example.gimnasio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EquipoNoEncontrado extends RuntimeException {
    public EquipoNoEncontrado(String nombre) {
        super("Equipo con nombre " + nombre + " no encontrado.");
    }
}