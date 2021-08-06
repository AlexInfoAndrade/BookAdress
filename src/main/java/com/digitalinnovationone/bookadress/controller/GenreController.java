package com.digitalinnovationone.bookadress.controller;

import com.digitalinnovationone.bookadress.dto.request.GenreDTO;
import com.digitalinnovationone.bookadress.dto.response.MessageResponseDTO;
import com.digitalinnovationone.bookadress.exception.GenreNotFoundException;
import com.digitalinnovationone.bookadress.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/genre")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GenreController {

    private GenreService genreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createGenre(@RequestBody @Valid GenreDTO genreDTO) {
        return genreService.createGenre(genreDTO);
    }

    @GetMapping
    public List<GenreDTO> listAll() {
        return genreService.listAll();
    }

    @GetMapping("/{id}")
    public GenreDTO findById(@PathVariable Long id) throws GenreNotFoundException {
        return genreService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody GenreDTO genreDTO)
            throws GenreNotFoundException {

        return genreService.updateById(id, genreDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws GenreNotFoundException {
        genreService.delete(id);
    }
}
