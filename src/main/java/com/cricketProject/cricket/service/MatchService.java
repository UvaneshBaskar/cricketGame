package com.cricketProject.cricket.service;

import com.cricketProject.cricket.model.MatchModel;
import com.cricketProject.cricket.model.TeamModel;
import com.cricketProject.cricket.repository.MatchRepository;
import com.cricketProject.cricket.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    public ArrayList<MatchModel> getAllMatches() {
        List<MatchModel> matchList = matchRepository.findAll();
        return new ArrayList<>(matchList);
    }

    public MatchModel scheduleMatch(MatchModel match) {
        LocalDateTime matchEndTime = LocalDateTime.now().plusMinutes(10L * match.getNumberOfOvers());
        match.setMatchDate(matchEndTime);
        match.setMatchResult(simulateMatch(match));

        return matchRepository.save(match);
    }

    public String simulateMatch(MatchModel match) {
        TeamModel team1 = teamRepository.findById(match.getTeam1Id()).orElse(null);
        TeamModel team2 = teamRepository.findById(match.getTeam2Id()).orElse(null);

        String result = team1.getTeamName() + " vs " + team2.getTeamName() + " Result: "
                + (Math.random() > 0.5 ? "Team 1 Wins" : "Team 2 Wins");

        match.setMatchResult(result);
        matchRepository.save(match);
        return result;
    }
}
