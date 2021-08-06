package com.digitalinnovationone.bookadress.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String title;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String author;

    @Valid
    @NotEmpty
    private GenreDTO genre;

    private List<AdressDTO> adresses;
}
