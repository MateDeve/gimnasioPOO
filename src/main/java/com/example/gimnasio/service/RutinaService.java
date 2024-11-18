package com.example.gimnasio.service;

import com.example.gimnasio.exception.RutinaNoEncontrada;
import com.example.gimnasio.model.Rutina;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class RutinaService {
    private List<Rutina> rutinas = new ArrayList<>();

    public void agregarRutina(Rutina rutina) {
        rutinas.add(rutina);
    }

    public void eliminarRutina(Rutina rutina) {
        rutinas.remove(rutina);
    }

    public List<Rutina> obtenerRutinas() {
        return rutinas;
    }

    public Rutina obtenerRutinaPorNombre(String nombre) {
        return rutinas.stream()
                .filter(rutina -> rutina.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new RutinaNoEncontrada(nombre));
    }
}
