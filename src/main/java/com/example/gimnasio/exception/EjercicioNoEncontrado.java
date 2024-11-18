package com.example.gimnasio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EjercicioNoEncontrado extends RuntimeException {
    public EjercicioNoEncontrado(String nombreEjercicio) {
        super("Ejercicio con nombre '" + nombreEjercicio + "' no encontrado.");
    }
}

