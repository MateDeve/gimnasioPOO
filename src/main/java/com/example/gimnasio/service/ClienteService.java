package com.example.gimnasio.service;

import com.example.gimnasio.model.Cliente;
import com.example.gimnasio.model.Rutina;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> obtenerTodos() {
        return clientes;
    }

    public Cliente agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    public Cliente buscarPorNombre(String nombre) {
        return clientes.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public List<Rutina> consultarRutinas(String nombre) {
        return buscarPorNombre(nombre).consultarHistorial();
    }
}
