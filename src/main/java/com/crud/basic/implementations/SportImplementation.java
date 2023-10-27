package com.crud.basic.implementations;

import com.crud.basic.entities.Sport;
import com.crud.basic.repositories.SportRepository;
import com.crud.basic.services.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SportImplementation implements SportService {

    @Autowired
    private SportRepository sportRepository;

    /*public void SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }*/

    @Override
    public List<Sport> getAllGames( ) {
        return sportRepository.findAll();
    }

    @Override
    public Sport getSportById(Long sportId) {
        Optional<Sport> game = sportRepository.findById(sportId);
        return game.orElse(null);
    }

    @Override
    public Sport createGame(Sport game) {
        return sportRepository.save(game);
    }

    @Override
    public Sport updateGame(Long sportId, Sport game) {
        if(sportRepository.existsById(sportId)){
           game.setSportId(sportId);
           return sportRepository.save(game);
        }
        return null;
    }

    @Override
    public void deleteGame(Long sportId) {
        sportRepository.deleteById(sportId);
    }

    @Override
    public List<Sport> getSportsByTeam(String team) {
        return sportRepository.findByTeam(team);
    }

    @Override
    public Set<Sport> getSportsByGame(String game) {
        return sportRepository.findByGame(game);
    }

}
