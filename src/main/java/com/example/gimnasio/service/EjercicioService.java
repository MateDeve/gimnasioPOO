package com.example.gimnasio.service;

import com.example.gimnasio.model.Ejercicio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EjercicioService {
    private List<Ejercicio> ejercicios = new ArrayList<>();

    // Agregar un ejercicio
    public void agregarEjercicio(Ejercicio ejercicio) {
        ejercicios.add(ejercicio);
    }

    // Obtener todos los ejercicios
    public List<Ejercicio> obtenerTodosLosEjercicios() {
        return ejercicios;
    }

    // Eliminar un ejercicio por nombre
    public boolean eliminarEjercicioPorNombre(String nombre) {
        return ejercicios.removeIf(ejercicio -> ejercicio.getNombre().equalsIgnoreCase(nombre));
    }

    // Buscar un ejercicio por nombre
    public Ejercicio buscarEjercicioPorNombre(String nombre) {
        return ejercicios.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}
