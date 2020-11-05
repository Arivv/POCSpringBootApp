package com.work.pocapp.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.pocapp.entity.GameRepository;
import com.work.pocapp.entity.Games;


@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	private List<Games> games = new ArrayList<>();
	
	public List<Games> findAllGames() {
		List<Games> games = new ArrayList<>();
		for(Games g: gameRepository.findAll()) {
			games.add(g);
		}
		return games;
	}
	
	public Games getGamesByName(String name){
		return gameRepository.findOne(name);
	}

	public void addNewGameToRepo(Games game) {
		gameRepository.save(game);
	}

	public void deleteGame(String name) {
		gameRepository.delete(name);
	}

	public void updateGames(String name, Games game) {
		gameRepository.save(game);
	}

}
