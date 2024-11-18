package com.example.gimnasio.controller;

import com.example.gimnasio.model.Cliente;
import com.example.gimnasio.model.Rutina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.gimnasio.service.ClienteService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;

    // Obtener todos los clientes
    @GetMapping("/todos")
    public List<Cliente> getAllClientes() {
        return clienteService.obtenerTodos();
    }

    // Agregar un nuevo cliente
    @PostMapping("/agregar")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.agregarCliente(cliente);
    }

    // Consultar un cliente por su nombre
    @GetMapping("/buscar/{nombre}")
    public Cliente getCliente(@PathVariable String nombre) {

        return clienteService.buscarPorNombre(nombre);
    }

    @GetMapping("/{nombre}/consultar-historial")
    public List<Rutina> getRutinaHistorial(@PathVariable String nombre) {
        return clienteService.consultarRutinas(nombre);
    }

    @PostMapping("/{nombre}/asignar-tarea")
    public String asignarTarea(@PathVariable String nombre, @RequestBody String tarea) {
        Cliente cliente = clienteService.buscarPorNombre(nombre); // Buscar el cliente
        if (cliente != null) {
            cliente.asignarTarea(tarea);
            return "Tarea asignada al cliente " + nombre;
        }
        return "Cliente no encontrado.";
    }

    @GetMapping("/{nombre}/mostrar-detalles")
    public String mostrarDetalles(@PathVariable String nombre) {
        Cliente cliente = clienteService.buscarPorNombre(nombre); // Buscar el cliente
        if (cliente != null) {
            cliente.mostrarDetalles();
            return "Detalles del cliente " + nombre + " mostrados en la consola.";
        }
        return "Cliente no encontrado.";
    }

}
