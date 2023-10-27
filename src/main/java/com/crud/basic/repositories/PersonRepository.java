package com.crud.basic.repositories;

import com.crud.basic.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PersonRepository extends JpaRepository <Person, Long>{
    Person findByUsername(String username);
    Set<Person> findByFaction(String faction);
    Set<Person> findByNationality(String nationality);

}
