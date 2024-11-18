package com.example.gimnasio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RutinaNoEncontrada extends RuntimeException{
    public RutinaNoEncontrada(String nombre) {
        super("Rutina con nombre '" + nombre + "' no encontrada.");
    }
}
