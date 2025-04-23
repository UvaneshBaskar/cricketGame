package com.cricketProject.cricket.repository;

import com.cricketProject.cricket.model.MatchModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository extends MongoRepository<MatchModel, Integer> {
}
