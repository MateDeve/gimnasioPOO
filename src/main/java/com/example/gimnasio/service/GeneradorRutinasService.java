package com.example.gimnasio.service;

import com.example.gimnasio.exception.RutinaNoEncontrada;
import com.example.gimnasio.model.Cliente;
import com.example.gimnasio.model.GeneradorRutinas;
import com.example.gimnasio.model.Rutina;
import org.springframework.stereotype.Service;

@Service
public class GeneradorRutinasService {

    private GeneradorRutinas generadorRutinas = new GeneradorRutinas();

    // Generar una nueva rutina para un cliente
    public Rutina generarRutinaParaCliente(Cliente cliente) {
        if (cliente == null) {
            throw new RutinaNoEncontrada("El cliente proporcionado es nulo.");
        }

        try {
            return generadorRutinas.generarRutina(cliente);
        } catch (Exception e) {
            throw new RutinaNoEncontrada("No se pudo generar la rutina para el cliente: " + cliente.getNombre());
        }
    }
}