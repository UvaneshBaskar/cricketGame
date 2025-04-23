package com.cricketProject.cricket.controller;

import com.cricketProject.cricket.model.PlayerModel;
import com.cricketProject.cricket.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController()
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/api/players")
    public ArrayList<PlayerModel> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/api/players/{playerId}")
    public PlayerModel getPlayerById(@PathVariable("playerId") int playerId) {
        return playerService.getPlayerById(playerId);
    }

    @PostMapping("/api/players")
    public PlayerModel addNewPlayer(@RequestBody PlayerModel player) {
        return playerService.addNewPlayer(player);
    }

    @PutMapping("/api/players/{playerId}")
    public PlayerModel updatePlayer(@PathVariable("playerId") int playerId, @RequestBody PlayerModel player) {
        return playerService.updatePlayer(playerId, player);
    }

    @DeleteMapping("/api/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId) {
        playerService.deletePlayer(playerId);
    }

}
