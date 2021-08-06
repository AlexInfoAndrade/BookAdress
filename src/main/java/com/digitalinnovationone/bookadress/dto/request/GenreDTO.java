package com.digitalinnovationone.bookadress.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;
}
