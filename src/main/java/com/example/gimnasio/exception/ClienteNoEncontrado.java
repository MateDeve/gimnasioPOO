package com.example.gimnasio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNoEncontrado extends RuntimeException {
    private final String mensaje;

    public ClienteNoEncontrado(String nombreCliente) {
        super("Cliente con nombre " + nombreCliente + "no encontrado. Verifique si está registrado");
        this.mensaje = "Cliente con nombre " + nombreCliente + " no encontrado. Verifique si está registrado";
    }

    public String getMensaje() {
        return mensaje;
    }

}
