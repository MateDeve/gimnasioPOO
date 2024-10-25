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
    @GetMapping("/{nombre}")
    public Cliente getCliente(@PathVariable String nombre) {

        return clienteService.buscarPorNombre(nombre);
    }

    @GetMapping("/{nombre}/consultar-historial")
    public List<Rutina> getRutinaHistorial(@PathVariable String nombre) {
        return clienteService.consultarRutinas(nombre);
    }
}
