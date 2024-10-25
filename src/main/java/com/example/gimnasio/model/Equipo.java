package com.example.gimnasio.model;

import java.util.Date;

public class Equipo {
    private String nombre;
    private String tipo;
    private String estado;
    private Date ultimoMantenimiento;

    public Equipo(String nombre, String tipo, String estado, Date ultimoMantenimiento) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
        this.ultimoMantenimiento = ultimoMantenimiento;
    }

    // Métodos
    public void registrarMantenimiento() {

        this.ultimoMantenimiento = new Date();
    }

    public String getEstado() {

        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMantenimiento() {
        return ultimoMantenimiento.toString();
    }
}
