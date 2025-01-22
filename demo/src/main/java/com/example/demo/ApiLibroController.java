// ApiLibroController.java
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiLibroController {

    @Autowired
    private ApiLibroService apiLibroService;

    // Endpoint que devuelve los libros desde la API de Gutendex
    @GetMapping("/libros")
    public ApiResponse obtenerLibros() {
        return apiLibroService.obtenerLibros();
    }
}