package com.crud.basic.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sports")
public class Sport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sport_sequence")
    @SequenceGenerator(name = "sport_sequence", sequenceName = "sport_sequence", allocationSize = 1)
    @Column(name = "sportId")
    private Long sportId;
    private String game;
    private String team;
    private String position;

    @ManyToMany(mappedBy = "sports")
    private Set<Person> persons = new HashSet<>();


}
