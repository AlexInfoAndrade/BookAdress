package com.digitalinnovationone.bookadress.service;

import com.digitalinnovationone.bookadress.dto.request.BookDTO;
import com.digitalinnovationone.bookadress.dto.response.MessageResponseDTO;
import com.digitalinnovationone.bookadress.entity.Book;
import com.digitalinnovationone.bookadress.exception.BookNotFoundException;
import com.digitalinnovationone.bookadress.mapper.BookMapper;
import com.digitalinnovationone.bookadress.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    public MessageResponseDTO createBook(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book bookSalved = bookRepository.save(bookToSave);
        return createMessageResponse(bookSalved.getId(), "Created book with id :: ");
    }

    public List<BookDTO> listAll() {
        List<Book> allBook = bookRepository.findAll();

        return allBook.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = verifyIfExists(id);

        return bookMapper.toDTO(book);
    }

    public void delete(Long id) throws BookNotFoundException {
        verifyIfExists(id);
        bookRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, BookDTO bookDTO) throws BookNotFoundException {
        verifyIfExists(id);

        Book bookToUpdate = bookMapper.toModel(bookDTO);

        Book bookUpdated = bookRepository.save(bookToUpdate);
        return createMessageResponse(bookUpdated.getId(), "Updated book with id :: ");
    }

    private Book verifyIfExists(Long id) throws BookNotFoundException {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
