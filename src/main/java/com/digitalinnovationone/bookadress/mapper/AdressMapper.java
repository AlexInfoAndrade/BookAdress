package com.digitalinnovationone.bookadress.mapper;

import com.digitalinnovationone.bookadress.dto.request.AdressDTO;
import com.digitalinnovationone.bookadress.entity.Adress;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdressMapper {

    AdressMapper INSTANCE = Mappers.getMapper(AdressMapper.class);

    Adress toModel(AdressDTO adressDTO);

    AdressDTO toDTO(Adress adress);
}
