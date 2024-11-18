package com.example.gimnasio.service;

import com.example.gimnasio.model.Entrenador;
import com.example.gimnasio.model.Cliente;
import com.example.gimnasio.model.Rutina;
import com.example.gimnasio.exception.ClienteNoEncontrado;
import com.example.gimnasio.exception.EntrenadorNoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntrenadorService {

    private List<Entrenador> entrenadores = new ArrayList<>();

    private final ClienteService clienteService;

    @Autowired
    public EntrenadorService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    // Agregar entrenador
    public void agregarEntrenador(Entrenador entrenador) {
        entrenadores.add(entrenador);
    }

    // Obtener todos los entrenadores
    public List<Entrenador> obtenerEntrenadores() {
        return entrenadores;
    }

    // Asignar cliente a un entrenador
    public void asignarCliente(String nombreEntrenador, Cliente cliente) {
        Entrenador entrenador = buscarEntrenadorPorNombre(nombreEntrenador);
        if (entrenador != null) {
            entrenador.asignarCliente(cliente);
        } else {
            throw new EntrenadorNoEncontrado(nombreEntrenador);
        }
    }

    public List<Cliente> obtenerClientesAsignados(String nombreEntrenador) {
        Entrenador entrenador = buscarEntrenadorPorNombre(nombreEntrenador);
        if (entrenador != null) {
            return entrenador.getClientesAsignados();
        } else {
            throw new EntrenadorNoEncontrado(nombreEntrenador);
        }
    }

    // Planificar rutina para un cliente
    public void planificarEntrenamiento(String nombreEntrenador, String nombreCliente, Rutina rutina) {
        Cliente cliente = clienteService.buscarPorNombre(nombreCliente);
        Entrenador entrenador = buscarEntrenadorPorNombre(nombreEntrenador);

        if (entrenador != null) {
            if (cliente != null) {
                entrenador.planificarEntrenamiento(cliente, rutina);
            } else {
                throw new ClienteNoEncontrado("Cliente no encontrado: " + nombreCliente);
            }
        } else {
            throw new EntrenadorNoEncontrado("Entrenador no encontrado: " + nombreEntrenador);
        }
    }


    // Buscar entrenador por nombre
    public Entrenador buscarEntrenadorPorNombre(String nombreEntrenador) {
        return entrenadores.stream()
                .filter(entrenador -> entrenador.getNombre().equalsIgnoreCase(nombreEntrenador))
                .findFirst()
                .orElseThrow(() -> new EntrenadorNoEncontrado(nombreEntrenador));
    }
}
