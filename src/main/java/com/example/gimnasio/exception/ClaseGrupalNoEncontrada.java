package com.example.gimnasio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClaseGrupalNoEncontrada extends RuntimeException{
    public ClaseGrupalNoEncontrada(String nombreClase) {
        super("Clase grupal con nombre '" + nombreClase + "' no encontrada.");
    }
}
