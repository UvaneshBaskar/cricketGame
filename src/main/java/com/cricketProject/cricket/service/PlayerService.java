package com.cricketProject.cricket.service;


import com.cricketProject.cricket.model.PlayerModel;
import com.cricketProject.cricket.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
        @Autowired
        private PlayerRepository playerRepo;

        public ArrayList<PlayerModel> getPlayers() {
        List<PlayerModel> playerList = playerRepo.findAll();
        return new ArrayList<>(playerList);
    }


        public PlayerModel addNewPlayer(PlayerModel player) {
        playerRepo.save(player);
        return player;
    }


        public PlayerModel getPlayerById(int playerId) {
        try {
            return playerRepo.findById(playerId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


        public PlayerModel updatePlayer(int playerId, PlayerModel player) {
        try {
            PlayerModel existingPlayer = playerRepo.findById(playerId).get();

            if (player.getPlayerName() != null) {
                existingPlayer.setPlayerName(player.getPlayerName());
            }
            if (player.getJerseyNumber() != 0) {
                existingPlayer.setJerseyNumber(player.getJerseyNumber());
            }
            if (player.getRole() != null) {
                existingPlayer.setRole(player.getRole());
            }
            if (player.getPlayerTeam() != null) {
                existingPlayer.setPlayerTeam(player.getPlayerTeam());
            }

            playerRepo.save(existingPlayer);

            return existingPlayer;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


        public void deletePlayer(int playerId) {
        try {
            playerRepo.deleteById(playerId);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
