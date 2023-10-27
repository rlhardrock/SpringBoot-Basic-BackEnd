package com.crud.basic.services;

import com.crud.basic.entities.Animal;
import com.crud.basic.repositories.AnimalRepository;

import java.util.List;
import java.util.Set;

public interface AnimalService {

    List<Animal> getAllAnimals();
    Animal getAnimalById(Long animalId);
    Animal createAnimal(Animal animal);
    Animal updateAnimal(Long animalIdd, Animal animal);
    void deleteAnimal(Long animalId);
    Animal getAnimalByName(String name);
    Set<Animal> getAnimalBySpecie(String specie);
    Set<Animal> getAnimalByBreed(String breed);

}
