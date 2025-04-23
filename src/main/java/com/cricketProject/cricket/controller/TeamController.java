package com.cricketProject.cricket.controller;

import com.cricketProject.cricket.model.TeamModel;
import com.cricketProject.cricket.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController()
public class TeamController {

    @Autowired
    private TeamService teamService;

    //Api for teams
    @GetMapping("/api/teams")
    public ArrayList<TeamModel> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/api/teams/{teamId}")
    public TeamModel getTeamById(@PathVariable("teamId") int teamId) {
        return teamService.getTeamById(teamId);
    }

    @PostMapping("/api/teams")
    public TeamModel addNewTeam(@RequestBody TeamModel team) {
        return teamService.addNewTeam(team);
    }

    @PutMapping("/api/teams/{teamId}")
    public TeamModel updateTeam(@PathVariable("teamId") int teamId, @RequestBody TeamModel team) {
        return teamService.updateTeam(teamId, team);
    }

    @DeleteMapping("/api/teams/{teamId}")
    public void deleteTeam(@PathVariable("teamId") int teamId) {
        teamService.deleteTeam(teamId);
    }
}
