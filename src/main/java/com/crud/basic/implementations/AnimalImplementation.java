package com.crud.basic.implementations;

import com.crud.basic.entities.Animal;
import com.crud.basic.repositories.AnimalRepository;
import com.crud.basic.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AnimalImplementation implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    /*public AnimalImplementation(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }*/

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal getAnimalById(Long animalId) {
        Optional<Animal> animal = animalRepository.findById(animalId);
        return animal.orElse(null);
    }

    @Override
    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal updateAnimal(Long animalId, Animal animal) {
        if (animalRepository.existsById(animalId)) {
            animal.setAnimalId(animalId);
            return animalRepository.save(animal);
        }
        return null;
    }

    @Override
    public void deleteAnimal(Long animalId) {
        animalRepository.deleteById(animalId);
    }

    @Override
    public Animal getAnimalByName(String name){
        return animalRepository.findByName(name);
    }

    @Override
    public Set<Animal> getAnimalBySpecie(String specie){
        return animalRepository.findBySpecie(specie);
    }

    @Override
    public Set<Animal> getAnimalByBreed(String breed){
        return animalRepository.findByBreed(breed);
    }


}
