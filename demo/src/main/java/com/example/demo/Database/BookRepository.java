package com.example.demo.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query("SELECT COUNT(b) FROM BookEntity b WHERE :language MEMBER OF b.languages")
    long countBooksByLanguage(@Param("language") String language);
}