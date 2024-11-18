package com.example.gimnasio.model;

import java.util.ArrayList;
import java.util.List;

public class GeneradorRutinas {

    // Metodo para generar una rutina basada en las características del cliente
    public Rutina generarRutina(Cliente cliente) {
        String nivel = cliente.getNivelExperiencia();
        String objetivo = cliente.getObjetivo();

        List<Ejercicio> ejercicios = new ArrayList<>();

        if (objetivo.equalsIgnoreCase("Perder peso")) {
            ejercicios.add(new Ejercicio("Correr", "Cardio", "Piernas", "", 30, 1, 60));
            ejercicios.add(new Ejercicio("Sentadillas", "Fuerza", "Piernas", "Glúteos", 15, 3, 60));
        } else if (objetivo.equalsIgnoreCase("Ganar masa muscular")) {
            ejercicios.add(new Ejercicio("Press de banca", "Fuerza", "Pectoral", "Hombros", 10, 4, 90));
            ejercicios.add(new Ejercicio("Peso muerto", "Fuerza", "Espalda baja", "Piernas", 12, 4, 120));
        }

        // Ajustar la duración según el nivel de experiencia
        int duracion = nivel.equalsIgnoreCase("Avanzado") ? 60 : 45;

        // Crear y retornar la rutina generada
        return new Rutina("Rutina Personalizada para " + cliente.getNombre(), ejercicios, duracion, nivel, objetivo);
    }
}
