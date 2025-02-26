package com.example.demo.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public long countBooksByLanguage(String language) {
        return bookRepository.countBooksByLanguage(language);
    }
}