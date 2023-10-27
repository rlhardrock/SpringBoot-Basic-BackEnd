package com.crud.basic.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_sequence")
    @SequenceGenerator(name = "vehicle_sequence", sequenceName = "vehicle_sequence", allocationSize = 1)
    @Column(name = "vehicleId")
    private Long vehicleId;

    @NotNull
    @NotEmpty
    @Size(min= 5, max = 10, message = "minimo 5 y maximo 10")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])[A-Z0-9]+$", message = "todas deben ser mayúsculas")
    @Column(name="license", unique = true)
    private String license;
    private String category;
    @NotBlank
    private String bodywork;
    private String platform;
    private String stream;
    private String suspension;
    public enum Engine { GASOLINE, DIESEL, ELECTRIC, HIDROGEN, NUCLEAR }
    @Enumerated(EnumType.STRING)
    private Engine engine;
    private String power;
    private String brand;
    private String model;
    private String year;
    private String paint;
    private boolean shield = false;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

}
