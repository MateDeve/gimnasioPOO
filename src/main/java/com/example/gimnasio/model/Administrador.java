package com.example.gimnasio.model;

import java.util.List;

public class Administrador extends Persona {

    public Administrador(String nombre, int edad, String genero) {

        super(nombre, edad, genero);
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