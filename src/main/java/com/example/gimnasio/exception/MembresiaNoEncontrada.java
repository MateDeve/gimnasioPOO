package com.example.gimnasio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MembresiaNoEncontrada extends RuntimeException {
    public MembresiaNoEncontrada(String tipo) {
        super("Membresía con tipo '" + tipo + "' no encontrada.");
    }
}
