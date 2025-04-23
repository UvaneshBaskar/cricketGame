package com.cricketProject.cricket.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "matches")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchModel {
    @Id
    private int id;
    private int team1Id;
    private int team2Id;
    private int numberOfOvers;
    private LocalDateTime matchDate;
    private String matchResult;


}
