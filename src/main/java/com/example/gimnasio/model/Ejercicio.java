package com.example.gimnasio.model;

public class Ejercicio {
    private String nombre;
    private String tipo;
    private String musculoPrincipal;
    private String musculoSecundario;
    private int repeticiones;
    private int series;
    private int descanso; // en segundos

    public Ejercicio(String nombre, String tipo, String musculoPrincipal, String musculoSecundario, int repeticiones, int series, int descanso) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.musculoPrincipal = musculoPrincipal;
        this.musculoSecundario = musculoSecundario;
        this.repeticiones = repeticiones;
        this.series = series;
        this.descanso = descanso;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMusculoPrincipal() {
        return musculoPrincipal;
    }

    public String getMusculoSecundario() {
        return musculoSecundario;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public int getSeries() {
        return series;
    }
    public int getDescanso() {
        return descanso;
    }

    public void mostrarDetalles() {
        System.out.println("Ejercicio: " + nombre + ", Reps: " + repeticiones + ", Series: " + series + ", Descanso: " + descanso + " seg");
    }
}
