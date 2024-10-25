package com.example.gimnasio.service;

import com.example.gimnasio.model.Administrador;
import com.example.gimnasio.model.Cliente;
import com.example.gimnasio.model.Equipo;
import com.example.gimnasio.model.Membresia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdministradorService {

    private List<Administrador> administradores = new ArrayList<>();
    private List<Equipo> equipos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    private final ClienteService clienteService;

    @Autowired
    public AdministradorService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Administrador agregarAdministrador(Administrador administrador) {
        administradores.add(administrador);
        return administrador;
    }

    public List<Administrador> obtenerAdministradores() {
        return administradores;
    }

    public Administrador obtenerAdministradorPorNombre(String nombre) {
        return administradores.stream()
                .filter(admin -> admin.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    public boolean eliminarAdministrador(String nombre) {
        return administradores.removeIf(admin -> admin.getNombre().equals(nombre));
    }


    public void asignarMembresia(String nombreAdministrador, String nombreCliente, Membresia membresia) {
        Administrador administrador = obtenerAdministradorPorNombre(nombreAdministrador);
        Cliente cliente = clienteService.buscarPorNombre(nombreCliente);
        administrador.asignarMembresia(cliente, membresia);
    }

}
