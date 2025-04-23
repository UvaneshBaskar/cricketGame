package com.cricketProject.cricket.service;


import com.cricketProject.cricket.model.TeamModel;
import com.cricketProject.cricket.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
        @Autowired
        private TeamRepository teamRepo;

        public ArrayList<TeamModel> getTeams() {
        List<TeamModel> teamList = teamRepo.findAll();
        return new ArrayList<>(teamList);
        }


        public TeamModel addNewTeam(TeamModel team) {
        teamRepo.save(team);
        return team;
        }


        public TeamModel getTeamById(int teamId) {
        try {
            return teamRepo.findById(teamId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }


        public TeamModel updateTeam(int teamId, TeamModel team) {
        try {
            TeamModel existingTeam = teamRepo.findById(teamId).get();

            if (team.getTeamName() != null) {
                existingTeam.setTeamName(team.getTeamName());
            }

            if (team.getHome() != null) {
                existingTeam.setHome(team.getHome());
            }

            teamRepo.save(existingTeam);

            return existingTeam;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }


        public void deleteTeam(int teamId) {
        try {
            teamRepo.deleteById(teamId);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }
}
