package com.example.gimnasio.service;

import com.example.gimnasio.exception.EquipoNoEncontrado;
import com.example.gimnasio.model.Equipo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EquipoService {

    private List<Equipo> equipos = new ArrayList<>();

    // Metodo para registrar el mantenimiento de un equipo por su nombre
    public boolean registrarMantenimiento(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombre)) {
                equipo.registrarMantenimiento();
                return true;
            }
        }
        return false;
    }

    // Metodo para agregar un nuevo equipo
    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    // Metodo para obtener todos los equipos
    public List<Equipo> obtenerEquipos() {
        return equipos;
    }

    // Metodo para obtener el estado de un equipo por su nombre
    public Equipo obtenerEquipoPorNombre(String nombre) {
        return equipos.stream()
                .filter(equipo -> equipo.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new EquipoNoEncontrado(nombre));
    }

    public boolean eliminarEquipo(String nombre) {
        Equipo equipo = equipos.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new EquipoNoEncontrado(nombre));
        equipos.remove(equipo);
        return true;
    }
}
