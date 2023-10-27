package com.crud.basic.services;

import com.crud.basic.entities.Person;

import java.util.List;
import java.util.Set;

public interface PersonService {

    List<Person> getAllPersons();
    Person getPersonById(Long personId);
    Person getPersonByUsername(String username);
    Person createPerson(Person person);
    Person updatePerson(Long personId, Person person);
    void deletePerson(Long personId);
    Set<Person> getPersonsByFaction(String faction);
    Set<Person> getPersonsByNationality(String nationality);
}
