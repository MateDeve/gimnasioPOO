package com.example.gimnasio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AdministradorNoEncontrado.class)
    public ResponseEntity<Map<String, String>> handleAdministradorNoEncontrado(AdministradorNoEncontrado ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Administrador no encontrado");
        response.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClaseGrupalNoEncontrada.class)
    public ResponseEntity<Map<String, String>> handleClaseGrupalNoEncontrada(ClaseGrupalNoEncontrada ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Clase Grupal No Encontrada");
        response.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClienteNoEncontrado.class)
    public ResponseEntity<Map<String, String>> handleClienteNoEncontrado(ClienteNoEncontrado ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Cliente no encontrado");
        response.put("mensaje", ex.getMensaje());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EjercicioNoEncontrado.class)
    public ResponseEntity<Map<String, String>> handleEjercicioNoEncontrado(EjercicioNoEncontrado ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Ejercicio No Encontrado");
        response.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntrenadorNoEncontrado.class)
    public ResponseEntity<Map<String, String>> handleEntrenadorNoEncontrado(EntrenadorNoEncontrado ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Entrenador no encontrado");
        response.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EquipoNoEncontrado.class)
    public ResponseEntity<Map<String, String>> handleEquipoNoEncontrado(EquipoNoEncontrado ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Equipo no encontrado");
        response.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MembresiaNoEncontrada.class)
    public ResponseEntity<Map<String, String>> handleMembresiaNoEncontrada(MembresiaNoEncontrada ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Membresia no encontrada");
        response.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RutinaNoEncontrada.class)
    public ResponseEntity<String> handleRutinaNoEncontrada(RutinaNoEncontrada ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
