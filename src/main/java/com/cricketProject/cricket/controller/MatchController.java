package com.cricketProject.cricket.controller;

import com.cricketProject.cricket.model.MatchModel;
import com.cricketProject.cricket.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/schedule")
    public MatchModel scheduleMatch(@RequestBody MatchModel match) {
        return matchService.scheduleMatch(match);
    }

    @GetMapping("/all")
    public List<MatchModel> getAllMatches() {
        return matchService.getAllMatches();
    }

}
