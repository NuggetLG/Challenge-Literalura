package com.example.demo.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    @Query("SELECT a FROM AuthorEntity a WHERE a.birth_year <= :year AND (a.death_year IS NULL OR a.death_year >= :year)")
    List<AuthorEntity> findAuthorsAliveInYear(@Param("year") int year);
}