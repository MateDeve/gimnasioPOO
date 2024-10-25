package com.example.gimnasio.model;

import java.util.List;

public class Rutina {
    private String nombre;
    private List<Ejercicio> ejercicios;
    private int duracion; // en minutos
    private String nivelExperiencia;
    private String objetivo;

    public Rutina(String nombre, List<Ejercicio> ejercicios, int duracion, String nivelExperiencia, String objetivo) {
        this.nombre = nombre;
        this.ejercicios = ejercicios;
        this.duracion = duracion;
        this.nivelExperiencia = nivelExperiencia;
        this.objetivo = objetivo;
    }

    // Métodos

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getNivelExperiencia() {
        return nivelExperiencia;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void mostrarRutina() {
        System.out.println("Rutina: " + nombre);
        for (Ejercicio ejercicio : ejercicios) {
            ejercicio.mostrarDetalles();
        }
    }

    public void agregarEjercicio(Ejercicio ejercicio) {

        ejercicios.add(ejercicio);
    }

    public void eliminarEjercicio(Ejercicio ejercicio) {

        ejercicios.remove(ejercicio);
    }
}
