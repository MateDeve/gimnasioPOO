package com.example.gimnasio.model;

import com.example.gimnasio.interfaces.Gestionable;

import java.util.List;

public class Administrador extends Persona implements Gestionable {

    public Administrador(String nombre, int edad, String genero) {

        super(nombre, edad, genero);
    }

    @Override
    public void asignarTarea(String tarea) {
        System.out.println("Administrador " + getNombre() + " asignó la tarea: " + tarea);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Administrador: " + getNombre() + ", Edad: " + getEdad() + ", Género: " + getGenero());
    }

    public void consultarEstadoEquipos(List<Equipo> equipos) {
        for (Equipo equipo : equipos) {
            System.out.println("Estado del equipo: " + equipo.getNombre() + " es" + equipo.getEstado());
        }
    }

    public void asignarMembresia (Cliente cliente, Membresia membresia) {
        cliente.asignarMembresia(membresia);
    }

}