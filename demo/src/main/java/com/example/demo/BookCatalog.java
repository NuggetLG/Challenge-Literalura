package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class BookCatalog {

    private final ApiLibroService apiLibroService;
    private final List<Book> catalog;

    @Autowired
    public BookCatalog(ApiLibroService apiLibroService) {
        this.apiLibroService = apiLibroService;
        this.catalog = new ArrayList<>();
    }

    public void buscarLibroPorTitulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título del libro:");
        String titulo = scanner.nextLine();
        Book book = apiLibroService.buscarLibroPorTitulo(titulo);
        if (book != null) {
            catalog.add(book);
            System.out.println("Libro encontrado y agregado al catálogo:");
            System.out.println(book);
        } else {
            System.out.println("No se encontró ningún libro con ese título.");
        }
    }

    public void listarTodosLosLibros() {
        if (catalog.isEmpty()) {
            System.out.println("No hay libros en el catálogo.");
        } else {
            System.out.println("Listado de todos los libros en el catálogo:");
            catalog.forEach(System.out::println);
        }
    }

    public void listarAutores() {
        if (catalog.isEmpty()) {
            System.out.println("No hay libros en el catálogo.");
        } else {
            System.out.println("Listado de todos los autores en el catálogo:");
            catalog.stream()
                    .map(Book::getAuthor)
                    .distinct()
                    .forEach(System.out::println);
        }
    }

    public void listarAutoresVivosEnAno() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el año:");
        int ano = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        List<Author> autoresVivos = catalog.stream()
                .map(Book::getAuthor)
                .filter(author -> author.getBirth_year() != null && (author.getDeath_year() == null || author.getDeath_year() > ano))
                .distinct()
                .collect(Collectors.toList());

        if (autoresVivos.isEmpty()) {
            System.out.println("No hay autores vivos en el año " + ano + ".");
        } else {
            System.out.println("Listado de autores vivos en el año " + ano + ":");
            autoresVivos.forEach(System.out::println);
        }
    }
}