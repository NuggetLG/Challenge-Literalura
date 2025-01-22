// ApiLibroService.java
package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class ApiLibroService {

    private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://gutendex.com/books/";

    public ApiLibroService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Book buscarLibroPorTitulo(String titulo) {
        String url = BASE_URL + "?search=" + titulo;
        ApiResponse response = restTemplate.getForObject(url, ApiResponse.class);
        if (response != null && !response.getResults().isEmpty()) {
            Book book = response.getResults().get(0);
            // Consider only the first language
            if (book.getLanguages() != null && !book.getLanguages().isEmpty()) {
                book.setLanguages(List.of(book.getLanguages().get(0)));
            }
            return book;
        }
        return null;
    }

    public ApiResponse obtenerLibros() {
        String url = BASE_URL;
        return restTemplate.getForObject(url, ApiResponse.class);
    }
}