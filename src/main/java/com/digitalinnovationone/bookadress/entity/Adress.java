package com.digitalinnovationone.bookadress.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    private Integer numberBookCase;

    @Column(nullable = false)
    private Integer numberDividerUpWards;

    @Column(nullable = false)
    private Integer numberDividerLeftToRight;

    private String reference;
}
