package com.digitalinnovationone.bookadress.service;

import com.digitalinnovationone.bookadress.dto.request.GenreDTO;
import com.digitalinnovationone.bookadress.dto.response.MessageResponseDTO;
import com.digitalinnovationone.bookadress.entity.Genre;
import com.digitalinnovationone.bookadress.exception.GenreNotFoundException;
import com.digitalinnovationone.bookadress.mapper.GenreMapper;
import com.digitalinnovationone.bookadress.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GenreService {

    private GenreRepository genreRepository;

    private final GenreMapper genreMapper = GenreMapper.INSTANCE;

    public MessageResponseDTO createGenre(GenreDTO genreDTO) {
        Genre genreToSave = genreMapper.toModel(genreDTO);

        Genre genreSalved = genreRepository.save(genreToSave);
        return createMessageResponse(genreSalved.getId(), "Created genre with id :: ");
    }

    public List<GenreDTO> listAll() {
        List<Genre> allGenre = genreRepository.findAll();

        return allGenre.stream()
                .map(genreMapper::toDTO)
                .collect(Collectors.toList());
    }

    public GenreDTO findById(Long id) throws GenreNotFoundException {
        Genre genre = verifyIfExists(id);

        return genreMapper.toDTO(genre);
    }

    public void delete(Long id) throws GenreNotFoundException {
        verifyIfExists(id);
        genreRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, GenreDTO genreDTO) throws GenreNotFoundException {
        verifyIfExists(id);

        Genre genreToUpdate = genreMapper.toModel(genreDTO);

        Genre genreUpdated = genreRepository.save(genreToUpdate);
        return createMessageResponse(genreUpdated.getId(), "Updated genre with id :: ");
    }

    private Genre verifyIfExists(Long id) throws GenreNotFoundException {
        return genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
