package com.crud.basic.implementations;

import com.crud.basic.entities.Person;
import com.crud.basic.repositories.PersonRepository;
import com.crud.basic.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PersonImplementation implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long personId) {
        return personRepository.findById(personId).orElse(null);
    }

    @Override
    public Person getPersonByUsername(String username) {
        return personRepository.findByUsername(username);
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long personId, Person person) {
        if (personRepository.existsById(personId)) {
            person.setPersonId(personId);
            return personRepository.save(person);
        }
        return null;
    }

    @Override
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public Set<Person> getPersonsByFaction(String faction) {
        return personRepository.findByFaction(faction);
    }

    @Override
    public Set<Person> getPersonsByNationality(String nationality) {
        return personRepository.findByNationality(nationality);
    }
}
