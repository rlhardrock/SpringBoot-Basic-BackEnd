package com.crud.basic.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animals")
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_sequence")
    @SequenceGenerator(name = "animal_sequence", sequenceName = "animal_sequence", allocationSize = 1)
    @Column(name = "animalId")
    private Long animalId;
    private String family;
    private String genre;
    private String specie;
    private String breed;
    private String fur;
    private String ecosystem;
    private String name;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

}
