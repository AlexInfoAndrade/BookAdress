package com.digitalinnovationone.bookadress.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdressNotFoundException extends Exception {

    public AdressNotFoundException(Long id) {
        super("Adress not found  with id :: " + id);
    }
}
