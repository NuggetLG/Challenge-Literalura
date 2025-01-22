package com.example.demo.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {

    private final AuthorRepository authorRepository;

    @Autowired
    public DatabaseService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }
}