package com.digitalinnovationone.bookadress.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GenreNotFoundException extends Exception {

    public GenreNotFoundException(Long id) {
        super("Genre not found  with id :: " + id);
    }
}
