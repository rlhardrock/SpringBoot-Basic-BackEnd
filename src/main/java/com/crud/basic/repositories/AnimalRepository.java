package com.crud.basic.repositories;

import com.crud.basic.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AnimalRepository extends JpaRepository <Animal, Long>{

    Animal findByName(String name);
    Set<Animal> findBySpecie(String specie);
    Set<Animal> findByBreed(String breed);

}
