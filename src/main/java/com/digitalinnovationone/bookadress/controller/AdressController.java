package com.digitalinnovationone.bookadress.controller;

import com.digitalinnovationone.bookadress.dto.request.AdressDTO;
import com.digitalinnovationone.bookadress.dto.response.MessageResponseDTO;
import com.digitalinnovationone.bookadress.exception.AdressNotFoundException;
import com.digitalinnovationone.bookadress.service.AdressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/adress")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdressController {

    private AdressService adressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createAdress(@RequestBody @Valid AdressDTO adressDTO) {
        return adressService.createAdress(adressDTO);
    }

    @GetMapping
    public List<AdressDTO> listAll() {
        return adressService.listAll();
    }

    @GetMapping("/{id}")
    public AdressDTO findById(@PathVariable Long id) throws AdressNotFoundException {
        return adressService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody AdressDTO adressDTO)
            throws AdressNotFoundException {

        return adressService.updateById(id, adressDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws AdressNotFoundException {
        adressService.delete(id);
    }
}
