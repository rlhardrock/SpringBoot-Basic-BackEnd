package com.crud.basic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import static org.hibernate.generator.EventType.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tracks")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName1;
    private String middleName2;
    private String middleName3;
    private String middleName4;
    private String middleName5;

    @Generated(event = {INSERT,UPDATE})
    @Column(columnDefinition =
            "AS CONCAT(" +
                    "	COALESCE(firstName, ''), " +
                    "	COALESCE(' ' + middleName1, ''), " +
                    "	COALESCE(' ' + middleName2, ''), " +
                    "	COALESCE(' ' + middleName3, ''), " +
                    "	COALESCE(' ' + middleName4, ''), " +
                    "	COALESCE(' ' + middleName5, ''), " +
                    "	COALESCE(' ' + lastName, '') " +
                    ")")
    private String fullName;


}
