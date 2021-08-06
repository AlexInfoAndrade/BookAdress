package com.digitalinnovationone.bookadress.service;

import com.digitalinnovationone.bookadress.dto.request.AdressDTO;
import com.digitalinnovationone.bookadress.dto.response.MessageResponseDTO;
import com.digitalinnovationone.bookadress.entity.Adress;
import com.digitalinnovationone.bookadress.exception.AdressNotFoundException;
import com.digitalinnovationone.bookadress.mapper.AdressMapper;
import com.digitalinnovationone.bookadress.repository.AdressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdressService {

    private AdressRepository adressRepository;

    private final AdressMapper adressMapper = AdressMapper.INSTANCE;

    public MessageResponseDTO createAdress(AdressDTO adressDTO) {
        Adress adressToSave = adressMapper.toModel(adressDTO);

        Adress adressSalved = adressRepository.save(adressToSave);
        return createMessageResponse(adressSalved.getId(), "Created adress with id :: ");
    }

    public List<AdressDTO> listAll() {
        List<Adress> allAdress = adressRepository.findAll();

        return allAdress.stream()
                .map(adressMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AdressDTO findById(Long id) throws AdressNotFoundException {
        Adress adress = verifyIfExists(id);

        return adressMapper.toDTO(adress);
    }

    public void delete(Long id) throws AdressNotFoundException {
        verifyIfExists(id);
        adressRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, AdressDTO adressDTO) throws AdressNotFoundException {
        verifyIfExists(id);

        Adress adressToUpdate = adressMapper.toModel(adressDTO);

        Adress adressUpdated = adressRepository.save(adressToUpdate);
        return createMessageResponse(adressUpdated.getId(), "Updated adress with id :: ");
    }

    private Adress verifyIfExists(Long id) throws AdressNotFoundException {
        return adressRepository.findById(id)
                .orElseThrow(() -> new AdressNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
