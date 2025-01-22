package com.example.demo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
    private String name;
    private Integer birth_year;
    private Integer death_year;

    // Default constructor
    public Author() {
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    @JsonAlias("name")
    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirth_year() {
        return birth_year;
    }

    @JsonAlias("birth_year")
    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public Integer getDeath_year() {
        return death_year;
    }

    @JsonAlias("death_year")
    public void setDeath_year(Integer death_year) {
        this.death_year = death_year;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birth_year=" + birth_year +
                ", death_year=" + death_year +
                '}';
    }
}