package com.example.demo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private String title;
    private Author author;
    private List<String> languages;
    private int download_count;

    // Default constructor
    public Book() {
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    @JsonAlias("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    @JsonAlias("authors")
    public void setAuthors(List<Author> authors) {
        if (authors != null && !authors.isEmpty()) {
            this.author = authors.get(0); // Consider only the first author
        }
    }

    public List<String> getLanguages() {
        return languages;
    }

    @JsonAlias("languages")
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getDownload_count() {
        return download_count;
    }

    @JsonAlias("download_count")
    public void setDownload_count(int download_count) {
        this.download_count = download_count;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", languages=" + languages +
                ", download_count=" + download_count +
                '}';
    }
}