package com.example.gimnasio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntrenadorNoEncontrado extends RuntimeException {
    public EntrenadorNoEncontrado(String nombreEntrenador) {
        super("Entrenador con nombre " + nombreEntrenador + " no encontrado.");
    }
}
