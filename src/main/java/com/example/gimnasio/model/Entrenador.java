package com.example.gimnasio.model;

import com.example.gimnasio.interfaces.Gestionable;

import java.util.ArrayList;
import java.util.List;

public class Entrenador extends Persona implements Gestionable {
    private String especialidad;
    private List<Cliente> clientesAsignados = new ArrayList<>();

    public Entrenador(String nombre, int edad, String genero, String especialidad, List<Cliente> clientesAsignados) {
        super(nombre, edad, genero);
        this.especialidad = especialidad;
    }

    @Override
    public void asignarTarea(String tarea) {
        System.out.println("Entrenador " + getNombre() + " está realizando la tarea: " + tarea);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Entrenador: " + getNombre() + ", Especialidad: " + especialidad);
    }

    // Métodos

    public String getEspecialidad() {
        return especialidad;
    }

    public List<Cliente> getClientesAsignados() {
        return clientesAsignados;
    }

    public void asignarCliente(Cliente cliente) {
         clientesAsignados.add(cliente);
    }


    public void planificarEntrenamiento(Cliente cliente, Rutina rutina) {
        cliente.registrarEntrenamiento(rutina);
    }
}
