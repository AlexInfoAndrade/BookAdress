package com.digitalinnovationone.bookadress.mapper;

import com.digitalinnovationone.bookadress.dto.request.GenreDTO;
import com.digitalinnovationone.bookadress.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    Genre toModel(GenreDTO genreDTO);

    GenreDTO toDTO(Genre genre);
}
