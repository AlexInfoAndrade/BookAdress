package com.digitalinnovationone.bookadress.repository;

import com.digitalinnovationone.bookadress.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
