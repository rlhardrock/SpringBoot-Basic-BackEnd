package com.crud.basic.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
    @SequenceGenerator(name = "person_sequence", sequenceName = "person_sequence", allocationSize = 1)
    @Column(name = "vehicleId")
    private long personId;
    @NotBlank
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "La primera letra debe ser mayúscula")
    private String username;
    @NotBlank
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,15}$", message = "wrong password")
    private String password;
    @NotBlank
    private String nationality;
    @NotBlank
    private String faction;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @Email(message = "correo electronico no valido")
    @Column(name="mail", unique = true)
    private String mail;
    @NotBlank
    @Size(min= 8, max = 15)
    private String phone;
    private boolean status = true;
    private String photograph;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "person")
    @JsonIgnore
    private List<Animal> animals;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "person")
    @JsonIgnore
    private Set<Vehicle> vehicles = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "persons_sports",
            joinColumns = @JoinColumn(name = "personId"),
            inverseJoinColumns = @JoinColumn(name = "sportId"))
    private Set<Sport> sports = new HashSet<>();

    //@NotEmpty @NotNull @NotBlank @Size @Pattern @Future @Past
    //@Trasient @DecimalMin @DecimalMax @Digist @CreditCardNumber @URL @Range

}
