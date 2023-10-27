package com.crud.basic.repositories;

import com.crud.basic.entities.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface SportRepository extends JpaRepository <Sport, Long> {

    List<Sport> findByTeam(String team);
    Set<Sport> findByGame(String game);

}
