package com.example.gimnasio.service;

import com.example.gimnasio.model.Cliente;
import com.example.gimnasio.model.GeneradorRutinas;
import com.example.gimnasio.model.Rutina;
import org.springframework.stereotype.Service;

@Service
public class GeneradorRutinasService {

    private GeneradorRutinas generadorRutinas = new GeneradorRutinas();

    // Generar una nueva rutina para un cliente
    public Rutina generarRutinaParaCliente(Cliente cliente) {
        return generadorRutinas.generarRutina(cliente);
    }
}