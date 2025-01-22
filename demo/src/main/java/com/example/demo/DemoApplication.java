package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final BookCatalog bookCatalog;

    @Autowired
    public DemoApplication(BookCatalog bookCatalog) {
        this.bookCatalog = bookCatalog;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        mostrarMenu();
    }

    private void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar autores");
            System.out.println("4. Listar autores vivos en un determinado año");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    bookCatalog.buscarLibroPorTitulo();
                    break;
                case 2:
                    bookCatalog.listarTodosLosLibros();
                    break;
                case 3:
                    bookCatalog.listarAutores();
                    break;
                case 4:
                    bookCatalog.listarAutoresVivosEnAno();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}