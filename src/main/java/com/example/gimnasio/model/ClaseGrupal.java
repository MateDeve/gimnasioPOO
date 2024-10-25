package com.example.gimnasio.model;

import java.util.ArrayList;
import java.util.List;

public class ClaseGrupal {
    private String nombre;
    private String tipo;
    private String horario;
    private Entrenador entrenador;
    private List<Cliente> clientesInscritos = new ArrayList<>();

    public ClaseGrupal(String nombre, String tipo, String horario, Entrenador entrenador) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.horario = horario;
        this.entrenador = entrenador;
    }

    // Métodos


    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getHorario() {
        return horario;
    }
    public Entrenador getEntrenador() {
        return entrenador;
    }

    public List<Cliente> getClientesInscritos() {
        return clientesInscritos;
    }

    public void inscribirCliente(Cliente cliente) {

        clientesInscritos.add(cliente);
    }

    public List<Cliente> mostrarParticipantes() {

        return clientesInscritos;
    }

    public boolean consultarDisponibilidad() {
        return true;
    }
}
