package com.crud.basic.services;

import com.crud.basic.entities.Sport;

import java.util.List;
import java.util.Set;

public interface SportService {

    List<Sport> getAllGames();
    Sport getSportById(Long id);
    Sport createGame(Sport game);
    Sport updateGame(Long id, Sport game);
    void deleteGame(Long id);
    List<Sport> getSportsByTeam(String team);
    Set<Sport> getSportsByGame(String game);


}
