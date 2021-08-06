package com.digitalinnovationone.bookadress.mapper;

import com.digitalinnovationone.bookadress.dto.request.BookDTO;
import com.digitalinnovationone.bookadress.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);
}
