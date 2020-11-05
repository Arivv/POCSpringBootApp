package com.work.pocapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.work.pocapp.business.GameService;
import com.work.pocapp.entity.Games;

@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping("/findAllGames")
	public List<Games> findAllGames(){
		
		return gameService.findAllGames();
	}
	
	@RequestMapping("/findGame/{name}")
	public Games getGamesByName(@PathVariable String name) {
		
		return gameService.getGamesByName(name);
	}

	@RequestMapping(method=RequestMethod.POST, value="/newGame")
	public void addNewGames(@RequestBody Games game ) {
		if(game.getName().isEmpty()) {
			
		}else
			gameService.addNewGameToRepo(game);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateGame/{name}")
	public void updateGames(@PathVariable String name, @RequestBody Games game) {
		
		gameService.updateGames(name, game);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteGame/{name}")
	public void deleteGame(@PathVariable String name) {
		
		gameService.deleteGame(name);
	}
}
