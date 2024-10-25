package com.example.gimnasio.service;

import com.example.gimnasio.model.ClaseGrupal;
import com.example.gimnasio.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClaseGrupalService {
    private List<ClaseGrupal> clasesGrupales = new ArrayList<>();

    // Agregar una nueva clase grupal
    public void agregarClaseGrupal(ClaseGrupal claseGrupal) {
        clasesGrupales.add(claseGrupal);
    }

    // Inscribir cliente a una clase grupal
    public void inscribirCliente(String nombreClase, Cliente cliente) {
        ClaseGrupal clase = buscarClasePorNombre(nombreClase);
        if (clase != null) {
            clase.inscribirCliente(cliente);
        }
    }

    // Mostrar todos los clientes inscritos en una clase grupal
    public List<Cliente> mostrarParticipantes(String nombreClase) {
        ClaseGrupal clase = buscarClasePorNombre(nombreClase);
        if (clase != null) {
            return clase.mostrarParticipantes();
        }
        return new ArrayList<>();
    }

    // Buscar una clase grupal por nombre
    private ClaseGrupal buscarClasePorNombre(String nombreClase) {
        return clasesGrupales.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombreClase))
                .findFirst()
                .orElse(null);
    }

    // Consultar disponibilidad de una clase grupal
    public boolean consultarDisponibilidad(String nombreClase) {
        ClaseGrupal clase = buscarClasePorNombre(nombreClase);
        return clase != null && clase.consultarDisponibilidad();
    }

    // Obtener todas las clases grupales
    public List<ClaseGrupal> obtenerClasesGrupales() {
        return clasesGrupales;
    }
}
