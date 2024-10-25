package com.example.gimnasio.service;

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
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombre)) {
                return equipo;
            }
        }
        return null; // Retorna null si no se encuentra el equipo
    }

    public boolean eliminarEquipo(String nombre) {
        Equipo equipo = obtenerEquipoPorNombre(nombre);
        if (equipo != null) {
            equipos.remove(equipo);
            return true; // Equipo eliminado exitosamente
        }
        return false; // Equipo no encontrado
    }
}
