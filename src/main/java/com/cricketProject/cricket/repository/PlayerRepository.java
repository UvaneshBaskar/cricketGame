package com.cricketProject.cricket.repository;

import com.cricketProject.cricket.model.PlayerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<PlayerModel, Integer> {
}
