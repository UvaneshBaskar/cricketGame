package com.cricketProject.cricket.repository;

import com.cricketProject.cricket.model.TeamModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<TeamModel, Integer> {
}
