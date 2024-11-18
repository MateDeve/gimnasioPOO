package com.example.gimnasio.model;

import com.example.gimnasio.interfaces.Gestionable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona implements Gestionable {
    private Membresia membresia;
    private List<Rutina> historialRutinas = new ArrayList<>();
    private String objetivo;
    private String nivelExperiencia;
    private static List<Cliente> clientes = new ArrayList<>();

    public Cliente(String nombre, int edad, Membresia membresia, String genero, String objetivo, String nivelExperiencia) {
        super(nombre, edad, genero);
        this.membresia = membresia;
        this.objetivo = objetivo;
        this.nivelExperiencia = nivelExperiencia;
    }

    @Override
    public void asignarTarea(String tarea) {
        System.out.println("Cliente " + getNombre() + " recibió la tarea: " + tarea);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Cliente: " + getNombre() + ", Nivel de experiencia: " + nivelExperiencia + ", Objetivo: " + objetivo);
    }


    // Métodos

    public List<Rutina> getHistorialRutinas() {
        return historialRutinas;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(String nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }

    public void asignarMembresia(Membresia membresia) {

        this.membresia = membresia;
    }

    public void registrarEntrenamiento(Rutina rutina) {

        historialRutinas.add(rutina);
    }

    public List<Rutina> consultarHistorial() {

        return historialRutinas;
    }

}
