package com.example.gimnasio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdministradorNoEncontrado extends RuntimeException{
    public AdministradorNoEncontrado(String nombreAdministrador) {
        super("Administador con nombre " + nombreAdministrador + " no encontrado. Verifique si está registrado");
    }
}
