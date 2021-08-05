package com.digitalinnovationone.bookadress.repository;

import com.digitalinnovationone.bookadress.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
